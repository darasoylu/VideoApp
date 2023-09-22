package com.darasoylu.videocontroller.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.darasoylu.videocontroller.database.dao.WatchListDao
import com.darasoylu.videocontroller.model.WatchList

@Database(
    entities = [WatchList::class],
    version = 1,
    exportSchema = false
)
abstract class VideoDatabase : RoomDatabase() {

    abstract val dao: WatchListDao

    companion object {
        @Volatile
        private var INSTANCE: VideoDatabase? = null

        fun getDatabase(context: Context): VideoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VideoDatabase::class.java,
                    "room_db"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }

}