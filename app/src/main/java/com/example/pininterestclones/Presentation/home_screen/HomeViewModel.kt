package com.example.pininterestclones.Presentation.home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pininterestclones.di.AppModule.retrofitService
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    var images: String by mutableStateOf("")

    init {
        getImages()
    }

    private fun getImages() {
        viewModelScope.launch {
            val result = retrofitService.getEditorialFeedImages()
            images = result
        }
    }

}