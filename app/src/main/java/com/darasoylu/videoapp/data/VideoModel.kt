package com.darasoylu.videoapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VideoModel(
    val videoId: Int,
    val videoName: String,
    val videoCategory: String,
    val videoYear: Int,
    val videoDescription: String,
    val videoImage: String,
    val videoUrl: String,
    val videoGenre: String,
) : Parcelable
