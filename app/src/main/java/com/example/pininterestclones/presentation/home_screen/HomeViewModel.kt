package com.example.pininterestclones.presentation.home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pininterestclones.data.mapper.toDomainModelList
import com.example.pininterestclones.di.AppModule.retrofitService
import com.example.pininterestclones.domain.model.ImageItem
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    var images: List<ImageItem> by mutableStateOf(emptyList())

    init {
        getImages()
    }

    private fun getImages() {
        viewModelScope.launch {
            val result = retrofitService.getEditorialFeedImages()
            images = result.toDomainModelList()
        }
    }

}