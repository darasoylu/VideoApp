package com.darasoylu.videocontroller.data

import com.darasoylu.videocontroller.model.MainModel
import com.darasoylu.videocontroller.model.VideoModel

object VideoSource {

    private val testVideoModels = listOf(
        VideoModel(
            videoId = 1,
            videoName = "Galatasaray",
            videoDescription = "Test",
            videoImage = "https://picsum.photos/200/300",
            videoUrl = "testVideoChess.mp4",
            videoGenre = "Pop"
        ),
        VideoModel(
            videoId = 2,
            videoName = "Galatasaray",
            videoDescription = "Test",
            videoImage = "https://picsum.photos/200/300",
            videoUrl = "testVideoChess.mp4",
            videoGenre = "Pop"
        ),
        VideoModel(
            videoId = 3,
            videoName = "Galatasaray",
            videoDescription = "Test",
            videoImage = "https://picsum.photos/200/300",
            videoUrl = "testVideoChess.mp4",
            videoGenre = "Pop"
        ),
        VideoModel(
            videoId = 4,
            videoName = "Galatasaray",
            videoDescription = "Test",
            videoImage = "https://picsum.photos/200/300",
            videoUrl = "testVideoChess.mp4",
            videoGenre = "Pop"
        ),
        VideoModel(
            videoId = 5,
            videoName = "Galatasaray",
            videoDescription = "Test",
            videoImage = "https://picsum.photos/200/300",
            videoUrl = "testVideoChess.mp4",
            videoGenre = "Pop"
        )
    )

    val testMainModel = listOf(
        MainModel("Genre1", testVideoModels),
        MainModel("Genre2", testVideoModels),
        MainModel("Genre3", testVideoModels),
        MainModel("Genre4", testVideoModels),
        MainModel("Genre5", testVideoModels),
        MainModel("Genre6", testVideoModels),
        MainModel("Genre7", testVideoModels),
        MainModel("Genre8", testVideoModels),
    )

}