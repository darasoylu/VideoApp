package com.darasoylu.videoapp.data

object VideoSource {

    val testVideoModels = listOf(
        VideoModel(
            videoId = 1,
            videoName = "The Dark Knight",
            videoCategory = "Movie",
            videoYear = 2008,
            videoDescription = "Test",
            videoImage = "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_FMjpg_UX1000_.jpg",
            videoUrl = "thedarkknight_trailer.mp4",
            videoGenre = "Action"
        ),
        VideoModel(
            videoId = 2,
            videoName = "Oppenheimer",
            videoCategory = "Movie",
            videoYear = 2023,
            videoDescription = "Test",
            videoImage = "https://m.media-amazon.com/images/M/MV5BMDBmYTZjNjUtN2M1MS00MTQ2LTk2ODgtNzc2M2QyZGE5NTVjXkEyXkFqcGdeQXVyNzAwMjU2MTY@._V1_FMjpg_UX1000_.jpg",
            videoUrl = "thedarkknight_trailer.mp4",
            videoGenre = "Drama"
        ),
        VideoModel(
            videoId = 3,
            videoName = "Inception",
            videoCategory = "Movie",
            videoYear = 2010,
            videoDescription = "Test",
            videoImage = "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_FMjpg_UX1000_.jpg",
            videoUrl = "thedarkknight_trailer.mp4",
            videoGenre = "Action"
        ),
        VideoModel(
            videoId = 4,
            videoName = "The Godfather",
            videoCategory = "Movie",
            videoYear = 1972,
            videoDescription = "Test",
            videoImage = "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UX1000_.jpg",
            videoUrl = "thedarkknight_trailer.mp4",
            videoGenre = "Drama"
        ),
        VideoModel(
            videoId = 5,
            videoName = "The Office",
            videoCategory = "Series",
            videoYear = 2005,
            videoDescription = "Test",
            videoImage = "https://m.media-amazon.com/images/M/MV5BMDNkOTE4NDQtMTNmYi00MWE0LWE4ZTktYTc0NzhhNWIzNzJiXkEyXkFqcGdeQXVyMzQ2MDI5NjU@._V1_FMjpg_UX1000_.jpg",
            videoUrl = "thedarkknight_trailer.mp4",
            videoGenre = "Comedy"
        ),
        VideoModel(
            videoId = 6,
            videoName = "Game Of Thrones",
            videoCategory = "Series",
            videoYear = 2011,
            videoDescription = "Test",
            videoImage = "https://m.media-amazon.com/images/M/MV5BN2IzYzBiOTQtNGZmMi00NDI5LTgxMzMtN2EzZjA1NjhlOGMxXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_FMjpg_UX1000_.jpg",
            videoUrl = "thedarkknight_trailer.mp4",
            videoGenre = "Action"
        ),
        VideoModel(
            videoId = 7,
            videoName = "Dark",
            videoCategory = "Series",
            videoYear = 2017,
            videoDescription = "Test",
            videoImage = "https://m.media-amazon.com/images/M/MV5BOTk2NzUyOTctZDdlMS00MDJlLTgzNTEtNzQzYjFhNjA0YjBjXkEyXkFqcGdeQXVyMjg1NDcxNDE@._V1_FMjpg_UX1000_.jpg",
            videoUrl = "thedarkknight_trailer.mp4",
            videoGenre = "Crime"
        )
    )

    val testMainModel = listOf(
        MainModel("Genre1", testVideoModels),
        MainModel("Genre2", testVideoModels),
        MainModel("Genre3", testVideoModels),
        MainModel("Genre4", testVideoModels),
    )

}