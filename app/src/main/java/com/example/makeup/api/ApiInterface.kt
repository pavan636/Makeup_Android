package com.example.makeup.api

import com.example.makeup.model.Makeup
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/api/v1/products.json?brand=maybelline")
    //getItems receives the response from api
    suspend fun getItems(): Response<Makeup>
}