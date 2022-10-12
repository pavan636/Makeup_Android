package com.example.makeup.room

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.makeup.model.MakeupItem
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
@SmallTest
class MakeupDBTest {
    private lateinit var database: MakeupDB
    private lateinit var dao: RoomDao
    @Before
    fun setup(){
        database= Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext<Context>() ,
            MakeupDB::class.java
        ).allowMainThreadQueries().build()
        dao= database.makeupDao()
    }
    @After
    @Throws(IOException::class)
    fun teardown(){
        database.close()
    }
    @Test
    fun insertMeme()= runBlocking {
        val Item=
            MakeupItem("\"//s3.amazonaws.com/donovanbailey/products/api_featured_images/000/000/495/original/open-uri20171223-4-9hrto4?1514063330","maybelline","Maybelline Face Studio Master Hi-Light Light Boosting bronzer formula has an expert \\nbalance of shade + shimmer illuminator for natural glow. Skin goes \\nsoft-lit with zero glitz.\\n\\n\\t\\tFor Best Results: Brush over all shades in palette and gently sweep over \\ncheekbones, brow bones, and temples, or anywhere light naturally touches\\n the face.\\n\\n\\t\\t\\n\\t\\n\\n ",495,"https://d3t32hsnjxo7q6.cloudfront.net/i/991799d3e70b8856686979f8ff6dcfe0_ra,w158,h184_pa,w158,h184.png","Maybelline Face Studio Master Hi-Light Light Booster Bronzer" ,"14.99")
        val Item1=MakeupItem("\"//s3.amazonaws.com/donovanbailey/products/api_featured_images/000/000/495/original/open-uri20171223-4-9hrto4?1514063330","maybelline","Maybelline Face Studio Master Hi-Light Light Boosting bronzer formula has an expert \\nbalance of shade + shimmer illuminator for natural glow. Skin goes \\nsoft-lit with zero glitz.\\n\\n\\t\\tFor Best Results: Brush over all shades in palette and gently sweep over \\ncheekbones, brow bones, and temples, or anywhere light naturally touches\\n the face.\\n\\n\\t\\t\\n\\t\\n\\n ",495,"https://d3t32hsnjxo7q6.cloudfront.net/i/991799d3e70b8856686979f8ff6dcfe0_ra,w158,h184_pa,w158,h184.png","Maybelline Face Studio Master Hi-Light Light Booster Bronzer","14.99" )
        val listItem:List<MakeupItem> = mutableListOf(Item,Item1)
//        dao.insertItem(listItem)
        val getMemeItems=dao.getItems()
        val byName=dao. getItems()
        assert(byName.size == getMemeItems.size)
    }
    @Test
    fun getAllMemes()= runBlocking {
        val Item=MakeupItem("\"//s3.amazonaws.com/donovanbailey/products/api_featured_images/000/000/495/original/open-uri20171223-4-9hrto4?1514063330","maybelline","Maybelline Face Studio Master Hi-Light Light Boosting bronzer formula has an expert \\nbalance of shade + shimmer illuminator for natural glow. Skin goes \\nsoft-lit with zero glitz.\\n\\n\\t\\tFor Best Results: Brush over all shades in palette and gently sweep over \\ncheekbones, brow bones, and temples, or anywhere light naturally touches\\n the face.\\n\\n\\t\\t\\n\\t\\n\\n ",495,"https://d3t32hsnjxo7q6.cloudfront.net/i/991799d3e70b8856686979f8ff6dcfe0_ra,w158,h184_pa,w158,h184.png","Maybelline Face Studio Master Hi-Light Light Booster Bronzer","14.99" )
        val Item1=MakeupItem("\"//s3.amazonaws.com/donovanbailey/products/api_featured_images/000/000/495/original/open-uri20171223-4-9hrto4?1514063330","maybelline","Maybelline Face Studio Master Hi-Light Light Boosting bronzer formula has an expert \\nbalance of shade + shimmer illuminator for natural glow. Skin goes \\nsoft-lit with zero glitz.\\n\\n\\t\\tFor Best Results: Brush over all shades in palette and gently sweep over \\ncheekbones, brow bones, and temples, or anywhere light naturally touches\\n the face.\\n\\n\\t\\t\\n\\t\\n\\n ",495,"https://d3t32hsnjxo7q6.cloudfront.net/i/991799d3e70b8856686979f8ff6dcfe0_ra,w158,h184_pa,w158,h184.png","Maybelline Face Studio Master Hi-Light Light Booster Bronzer","14.99" )
        val listMeme:List<MakeupItem> = mutableListOf(Item,Item1)
//        dao.insertItem(listMeme)
        val totalItems=dao.getItems()
        assert(totalItems.isNotEmpty())
    }
}