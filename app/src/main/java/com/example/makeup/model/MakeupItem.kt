package com.example.makeup.model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cosmetics")
data class MakeupItem(
    val api_featured_image: String,
    val brand: String,
    val description: String,
    @PrimaryKey
    val id: Int,
    val image_link: String,
    val name: String,
    val price: String

    )