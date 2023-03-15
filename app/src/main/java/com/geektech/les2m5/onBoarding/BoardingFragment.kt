package com.geektech.les2m5.onBoarding

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.geektech.les2m5.Preferences
import com.geektech.les2m5.R
import com.geektech.les2m5.databinding.FragmentBoardingBinding
import com.geektech.tasks.ui.onBoarding.adapter.onBoardingAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BoardingFragment : Fragment() {
    private lateinit var binding: FragmentBoardingBinding
    private lateinit var adapter: onBoardingAdapter

    @Inject
    lateinit var preferences: Preferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = onBoardingAdapter(this::onClick)
        binding.boardingVp.adapter = adapter
        binding.indicator.setViewPager(binding.boardingVp)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)
            //if (preferences.isUserSeen()) {
         //   findNavController().navigate(R.id.homeFragment)
      //  }
    }

    fun onClick() {
        preferences.userSeenOnBoard()
        findNavController().navigate(R.id.homeFragment)
        Log.e("xvr", "Fragment")
    }
}


