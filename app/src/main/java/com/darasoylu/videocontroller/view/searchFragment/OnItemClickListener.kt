package com.darasoylu.videocontroller.view.searchFragment

import com.darasoylu.videocontroller.model.VideoModel

interface OnItemClickListener {
    fun watchListAddClick(watchListModel: VideoModel)

    fun watchListDeleteClick(id: Int)
}