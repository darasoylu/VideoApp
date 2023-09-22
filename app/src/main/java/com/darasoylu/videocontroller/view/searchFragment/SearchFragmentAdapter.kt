package com.darasoylu.videocontroller.view.searchFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.darasoylu.videocontroller.R
import com.darasoylu.videocontroller.databinding.SearchItemBinding
import com.darasoylu.videocontroller.model.VideoModel
import kotlinx.coroutines.withContext

class SearchFragmentAdapter(
    private val context: Context,
    private var videoList: ArrayList<VideoModel>,
    private var idList: List<Int>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<SearchFragmentAdapter.SearchFragmentAdapterViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchFragmentAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        return SearchFragmentAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return videoList.size
    }

    override fun onBindViewHolder(holder: SearchFragmentAdapterViewHolder, position: Int) {
        val model = videoList[position]
        holder.binding.apply {
            searchListVideoImage.load(model.videoImage)
            searchListVideoName.text = model.videoName
            searchListVideoCategory.text = model.videoCategory
            searchListVideoYear.text = model.videoYear.toString()
            searchListVideoGenre.text = model.videoGenre
        }

        if (idList.contains(model.videoId)) {
            holder.binding.searchListBookmark.visibility = View.VISIBLE
            holder.binding.searchListUnBookmark.visibility = View.GONE
        } else {
            holder.binding.searchListBookmark.visibility = View.GONE
            holder.binding.searchListUnBookmark.visibility = View.VISIBLE
        }

        holder.binding.searchListUnBookmark.setOnClickListener {
            Toast.makeText(context, "Video Added", Toast.LENGTH_SHORT).show()
            itemClickListener.watchListAddClick(model)
            holder.binding.searchListUnBookmark.visibility = View.GONE
            holder.binding.searchListBookmark.visibility = View.VISIBLE
        }
        holder.binding.searchListBookmark.setOnClickListener {
            Toast.makeText(context, "Video Removed", Toast.LENGTH_SHORT).show()
            itemClickListener.watchListDeleteClick(model.videoId)
            holder.binding.searchListBookmark.visibility = View.GONE
            holder.binding.searchListUnBookmark.visibility = View.VISIBLE
        }
    }

    inner class SearchFragmentAdapterViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val binding = SearchItemBinding.bind(itemView)
    }

    fun filterList(videoListFilter: ArrayList<VideoModel>) {
        videoList = videoListFilter
        notifyDataSetChanged()
    }

    fun changeList(filteredList: List<Int>) {
        idList = filteredList
    }

}