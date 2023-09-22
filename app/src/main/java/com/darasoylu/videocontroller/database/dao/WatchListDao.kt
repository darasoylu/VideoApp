package com.darasoylu.videocontroller.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.darasoylu.videocontroller.model.WatchList

@Dao
interface WatchListDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertVideo(watchList: WatchList)

    @Query("DELETE FROM watchlist_table WHERE uid=:id")
    suspend fun deleteVideo(id: Int)

    @Query("SELECT uid FROM watchlist_table")
    fun getIds() : List<Int>
}