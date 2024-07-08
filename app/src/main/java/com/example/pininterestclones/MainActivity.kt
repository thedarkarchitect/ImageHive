package com.example.pininterestclones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pininterestclones.Presentation.home_screen.HomeScreen
import com.example.pininterestclones.Presentation.home_screen.HomeViewModel
import com.example.pininterestclones.ui.theme.PinInterestClonesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PinInterestClonesTheme {
                val viewModel = viewModel<HomeViewModel>()
                HomeScreen( images = viewModel.images)
            }
        }
    }
}

