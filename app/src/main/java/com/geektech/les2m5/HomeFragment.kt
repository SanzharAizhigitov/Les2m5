package com.geektech.les2m5

import android.net.DnsResolver.Callback
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.geektech.les2m5.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Response


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calculateIv.setOnClickListener {
            LoveService().api.calculatePercentage(
                firstName = binding.outlinedTextFieldFname.editText?.text.toString(),
                secondName = binding.outlinedTextFieldSname.editText?.text.toString()
            ).enqueue(object : retrofit2.Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful) {
                        findNavController().navigate(
                            R.id.resultFragment, bundleOf(
                                "model" to response.body()
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("xvr", "onFailure: ${t.message}")
                }

            })
        }
    }
}