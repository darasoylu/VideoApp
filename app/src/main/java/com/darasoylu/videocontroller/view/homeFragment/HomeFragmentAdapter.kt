package com.darasoylu.videocontroller.view.homeFragment

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.darasoylu.videocontroller.R
import com.darasoylu.videocontroller.databinding.ParentItemBinding
import com.darasoylu.videocontroller.model.MainModel

class HomeFragmentAdapter(private val videoModels: List<MainModel>) :
    RecyclerView.Adapter<HomeFragmentAdapter.HomeFragmentAdapterViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeFragmentAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_item, parent, false)
        return HomeFragmentAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return videoModels.size
    }

    override fun onBindViewHolder(holder: HomeFragmentAdapterViewHolder, position: Int) {
        holder.binding.apply {
            val model = videoModels[position]
            videoGenre.text = model.genre

            val videoAdapter = VideoAdapter(model.videoModels)
            parentItemRV.adapter = videoAdapter
        }
    }

    inner class HomeFragmentAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ParentItemBinding.bind(itemView)
    }
}