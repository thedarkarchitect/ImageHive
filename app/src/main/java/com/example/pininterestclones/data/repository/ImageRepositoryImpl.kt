package com.example.pininterestclones.data.repository

import com.example.pininterestclones.data.remote.ApiService
import com.example.pininterestclones.domain.model.ImageItem
import com.example.pininterestclones.domain.repository.ImageRepository

class ImageRepositoryImpl(
    private val apiService: ApiService
): ImageRepository {
    override suspend fun getEditorialFeedImages(): List<ImageItem> {
        TODO("Not yet implemented")
    }
}