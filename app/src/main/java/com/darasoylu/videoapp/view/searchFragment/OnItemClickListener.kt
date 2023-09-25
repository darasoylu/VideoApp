package com.darasoylu.videoapp.view.searchFragment

import com.darasoylu.videoapp.data.VideoModel

interface OnItemClickListener {
    fun watchListAddClick(watchListModel: VideoModel)

    fun watchListDeleteClick(id: Int)
}