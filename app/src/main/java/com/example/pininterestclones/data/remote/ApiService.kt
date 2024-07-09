package com.example.pininterestclones.data.remote

import com.example.pininterestclones.data.remote.dto.ImageDtoItem
import com.example.pininterestclones.utils.Constants.APIKEY
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers("Authorization: Client-ID $APIKEY")
    @GET("/photos")
    suspend fun getEditorialFeedImages(): List<ImageDtoItem>
}