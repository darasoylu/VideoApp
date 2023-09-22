package com.darasoylu.videocontroller.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    "watchlist_table"
)
data class WatchList(
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    val videoName: String,
    val videoYear: Int,
)
