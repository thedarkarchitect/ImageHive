package com.example.pininterestclones.di

import com.example.pininterestclones.data.remote.ApiService
import com.example.pininterestclones.utils.Constants.BASEURL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object AppModule {

    val contentType = "application/json".toMediaType()
    val json = Json { ignoreUnknownKeys = true } //this is a json object that will ignore the fields we have removed from dto that will not be used when data got from api service

    private val retrofit = Retrofit.Builder() 
//        .addConverterFactory(ScalarsConverterFactory.create()) //this return the whole json from Api raw
        .addConverterFactory(json.asConverterFactory(contentType)) //this returns the json from the api service only with the fields requested
        .baseUrl(BASEURL)
        .build()

    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}