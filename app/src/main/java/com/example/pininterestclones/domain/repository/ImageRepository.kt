package com.example.pininterestclones.domain.repository

import com.example.pininterestclones.domain.model.ImageItem

interface ImageRepository {
    suspend fun getEditorialFeedImages(): List<ImageItem>
}