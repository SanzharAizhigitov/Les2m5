package com.geektech.les2m5

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.geektech.les2m5.databinding.FragmentHomeBinding
import com.geektech.les2m5.remote.LoveModel
import com.geektech.les2m5.remote.LoveService
import com.geektech.les2m5.viewmodel.LoveViewModel
import retrofit2.Call
import retrofit2.Response


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
private val viewModel:LoveViewModel by viewModels()
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
            viewModel.getLiveLove(binding.outlinedTextFieldFname.editText?.text.toString(), binding.outlinedTextFieldSname.editText?.text.toString() )
                .observe(viewLifecycleOwner, Observer {loveModel->
findNavController().navigate(R.id.resultFragment, bundleOf(
    "model" to loveModel
))
                })
        }
    }
}