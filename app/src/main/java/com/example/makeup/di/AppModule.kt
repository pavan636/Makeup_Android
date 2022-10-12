package com.example.makeup.di

import android.content.Context
import com.example.makeup.api.ApiInterface
import com.example.makeup.room.MakeupDB
import com.example.makeup.room.RoomDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// @InstallIn to tell Hilt which Android class each module will be used or installed in.
// We are declaring the life cycle scope of all the dependency we are providing under AppModule
// SingletonComponent   -> Application scope
// as long as the application survives the providers will survive..

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // 1
    @Provides
    fun providesBaseUrl(): String = "https://makeup-api.herokuapp.com/"

    // 2 needs step 1
    @Provides
    @Singleton
    fun providesRetrofitBuilder(baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    // 3 needs step 2
    @Provides
    fun providesApiPostService(retrofit: Retrofit): ApiInterface =
        retrofit.create(ApiInterface::class.java)

    @Provides
    @Singleton
    fun providesDatabseBuilder(@ApplicationContext context: Context): MakeupDB =
        MakeupDB.getDB(context)

    @Provides
    fun providesrepository(makeDatabase: MakeupDB): RoomDao =
        makeDatabase.makeupDao()


}

