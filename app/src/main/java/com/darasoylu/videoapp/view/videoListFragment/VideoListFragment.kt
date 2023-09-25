package com.darasoylu.videoapp.view.videoListFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.darasoylu.videoapp.R
import com.darasoylu.videoapp.databinding.FragmentVideoListBinding
import com.google.android.material.tabs.TabLayout


class VideoListFragment : Fragment() {

    private lateinit var binding: FragmentVideoListBinding
    private lateinit var adapter: VideoListFragmentPageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVideoListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = VideoListFragmentPageAdapter(childFragmentManager, lifecycle)

        binding.fragmentVideoListTabLayout.addTab(
            binding.fragmentVideoListTabLayout.newTab().setText("Movies")
        )
        binding.fragmentVideoListTabLayout.addTab(
            binding.fragmentVideoListTabLayout.newTab().setText("Series")
        )

        binding.fragmentVideoListViewpager.adapter = adapter

        binding.fragmentVideoListTabLayout.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    binding.fragmentVideoListViewpager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        binding.fragmentVideoListViewpager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.fragmentVideoListTabLayout.selectTab(
                    binding.fragmentVideoListTabLayout.getTabAt(
                        position
                    )
                )
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        findNavController().navigate(R.id.homeFragment)
    }

}