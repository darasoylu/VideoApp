package com.darasoylu.videocontroller.view.homeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.darasoylu.videocontroller.R
import com.darasoylu.videocontroller.databinding.VideoItemBinding
import com.darasoylu.videocontroller.model.VideoModel

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

            val bundle = Bundle()
            bundle.putParcelable("videoModelBundle", videoModel[position])
            videoItemImage.setOnClickListener {
                it.findNavController().navigate(R.id.action_homeFragment_to_videoFragment, bundle)
            }
        }
    }

    inner class VideoAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = VideoItemBinding.bind(itemView)
    }
}