package com.darasoylu.videocontroller.view.homeFragment

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.darasoylu.videocontroller.R
import com.darasoylu.videocontroller.data.VideoSource
import com.darasoylu.videocontroller.database.dao.WatchListDao
import com.darasoylu.videocontroller.database.VideoDatabase
import com.darasoylu.videocontroller.databinding.FragmentHomeBinding
import com.darasoylu.videocontroller.model.WatchList
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()

        binding.buttonSearch.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }

    }

    private fun setAdapter() {
        binding.apply {
            fragmentHomeRV.adapter = HomeFragmentAdapter(VideoSource.testMainModel)
        }
    }

}