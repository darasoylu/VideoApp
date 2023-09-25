package com.darasoylu.videoapp.view.homeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.darasoylu.videoapp.R
import com.darasoylu.videoapp.databinding.VideoItemBinding
import com.darasoylu.videoapp.data.VideoModel

class VideoAdapter(private val videoModel: List<VideoModel>) :
    RecyclerView.Adapter<VideoAdapter.VideoAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false)
        return VideoAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return videoModel.size
    }

    override fun onBindViewHolder(holder: VideoAdapterViewHolder, position: Int) {
        holder.binding.apply {
            videoItemImage.load(videoModel[position].videoImage)
            videoItemName.text = videoModel[position].videoName

            val bundle = Bundle()
            bundle.putParcelable("videoModelBundle", videoModel[position])
            videoPlayBt.setOnClickListener {
                it.findNavController().navigate(R.id.action_homeFragment_to_videoFragment, bundle)
            }
        }
    }

    inner class VideoAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = VideoItemBinding.bind(itemView)
    }
}