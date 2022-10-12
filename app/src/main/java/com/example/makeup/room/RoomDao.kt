package com.example.makeup.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.makeup.model.MakeupItem

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    // Inserts the data into the database
    suspend fun insertItem(makeupItem: MakeupItem)

    @Query("SELECT * from cosmetics")
    suspend fun getItems(): List<MakeupItem>
}