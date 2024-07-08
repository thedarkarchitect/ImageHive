package com.example.pininterestclones.di

import com.example.pininterestclones.data.remote.ApiService
import com.example.pininterestclones.utils.Constants.BASEURL
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object AppModule {

    private val retrofit = Retrofit.Builder() 
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASEURL)
        .build()

    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}