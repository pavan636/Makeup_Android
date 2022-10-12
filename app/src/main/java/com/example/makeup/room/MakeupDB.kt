package com.example.makeup.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.makeup.model.MakeupItem

@Database(entities = [MakeupItem::class], version = 1)
abstract class MakeupDB : RoomDatabase() {

    abstract fun makeupDao(): RoomDao

    companion object {
        private var INSTANCE: MakeupDB? = null

        fun getDB(context: Context): MakeupDB {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    MakeupDB::class.java,
                    "CosmeticDB"
                ).build()
            }
            return INSTANCE!!
        }
    }
}