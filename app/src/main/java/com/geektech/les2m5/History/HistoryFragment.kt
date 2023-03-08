package com.geektech.les2m5.History

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.les2m5.App
import com.geektech.les2m5.R
import com.geektech.les2m5.databinding.FragmentHistoryBinding
import com.geektech.les2m5.databinding.FragmentResultBinding
import com.geektech.les2m5.remote.LoveModel
import com.geektech.les2m5.room.AppDataBase

class HistoryFragment : Fragment() {
    lateinit var binding: FragmentHistoryBinding
    lateinit var adapter: HistoryAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
adapter = HistoryAdapter()
        binding.historyRv.adapter = adapter
adapter.addLoves(App.appDatabase.loveDao().getAllForAlphabet())
        binding.homeBtn.setOnClickListener{
            findNavController().navigate(R.id.homeFragment)
        }
        }
    }
