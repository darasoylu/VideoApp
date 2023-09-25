package com.darasoylu.videoapp.view.searchFragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.darasoylu.videoapp.R
import com.darasoylu.videoapp.data.VideoSource
import com.darasoylu.videoapp.database.VideoDatabase
import com.darasoylu.videoapp.databinding.FragmentSearchBinding
import com.darasoylu.videoapp.data.VideoModel
import com.darasoylu.videoapp.data.WatchList
import kotlinx.coroutines.launch

class SearchFragment : Fragment(), OnItemClickListener {
    private lateinit var database: VideoDatabase

    private lateinit var searchFragmentAdapter: SearchFragmentAdapter

    private lateinit var binding: FragmentSearchBinding

    private var searchVideoModels = ArrayList(VideoSource.testVideoModels)

    private val filteredVideoList: ArrayList<VideoModel> = ArrayList()
    private lateinit var getWatchListIds: List<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = VideoDatabase.getDatabase(requireContext())
        getWatchListIds = database.dao.getIds()

        setAdapter()


        binding.editSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val checkText = p0.toString()
                if (checkText.isEmpty()) {
                    binding.buttonSearch.visibility = View.VISIBLE
                    binding.buttonClose.visibility = View.INVISIBLE
                } else {
                    binding.buttonSearch.visibility = View.INVISIBLE
                    binding.buttonClose.visibility = View.VISIBLE
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                getWatchListIds = database.dao.getIds()
                searchFragmentAdapter.changeList(getWatchListIds)
                filter(p0.toString())
            }

        })

        binding.buttonClose.setOnClickListener {
            binding.editSearch.text = null
            binding.buttonClose.visibility = View.INVISIBLE
            binding.buttonSearch.visibility = View.VISIBLE
        }

        binding.buttonBack.setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_homeFragment,)
        }

    }

    private fun setAdapter() {
        searchFragmentAdapter = SearchFragmentAdapter(requireContext(), searchVideoModels,getWatchListIds, this)
        binding.apply {
            searchFragmentRV.adapter = searchFragmentAdapter
        }
    }

    private fun filter(text: String) {
        filteredVideoList.clear()
        for (videoModel in VideoSource.testVideoModels){
            if (videoModel.videoName.toLowerCase().contains(text.toLowerCase())){
                filteredVideoList.add(videoModel)
            }
        }
        searchFragmentAdapter.filterList(filteredVideoList)
    }

    override fun watchListAddClick(watchListVideoModel: VideoModel) {
        val addVideo = WatchList(watchListVideoModel.videoId, watchListVideoModel.videoName, watchListVideoModel.videoYear)

        viewLifecycleOwner.lifecycleScope.launch {
            database.dao.insertVideo(addVideo)
        }
    }

    override fun watchListDeleteClick(id: Int) {
        viewLifecycleOwner.lifecycleScope.launch {
            database.dao.deleteVideo(id)
        }
    }



}
