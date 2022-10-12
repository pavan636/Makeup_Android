package com.example.makeup.repository

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.makeup.api.ApiInterface
import com.example.makeup.model.Makeup
import com.example.makeup.room.RoomDao
import com.example.makeup.util.MyUtil
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ItemRepository @Inject constructor(
    private val apiInterface: ApiInterface,
    private val makeupDB: RoomDao,
    @ApplicationContext private val applicationContext: Context
) {

    private val itemLiveData = MutableLiveData<Makeup>()

    val items: LiveData<Makeup>
        get() = itemLiveData

    suspend fun getMakeupItem() {
        val resultfromdb = makeupDB.getItems()
        if (resultfromdb.isNotEmpty()) {
            val makeup = Makeup()
            makeup.addAll(resultfromdb)

            itemLiveData.postValue(makeup)
        } else {
// Checks if the Internet connection is available And then stores the data inside the body
            if (MyUtil.isInternetAvailable(applicationContext)) {
                val result = apiInterface.getItems()
                if (result.body() != null) {
                    result.body()!!.map {
                        makeupDB.insertItem(it)
                    }

                    itemLiveData.postValue(result.body())
                }
            } else {
                Toast.makeText(applicationContext, "Check Network", Toast.LENGTH_SHORT).show()

            }
        }

    }

}