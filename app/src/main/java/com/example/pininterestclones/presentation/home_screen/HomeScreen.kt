package com.example.pininterestclones.presentation.home_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pininterestclones.domain.model.ImageItem
import com.example.pininterestclones.presentation.components.ImageVerticalGrid
import com.example.pininterestclones.presentation.components.ZoomedImageCard
import com.example.pininterestclones.ui.theme.PinInterestClonesTheme


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    images: List<ImageItem>,
    onImageClick: (String) -> Unit
) {

    //this boolean with control the gesture methods
    var showImagePreview by remember { mutableStateOf(false) }
    var activeImage by remember { mutableStateOf<ImageItem?>(null) }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageVerticalGrid(
                images = images,
                onImageClick = onImageClick,
                onImageDragStart = { image ->
                    activeImage = image
                    showImagePreview = true
                },
                onImageDragEnd = {
                    showImagePreview = false
                }
            )
        }
        ZoomedImageCard(
            modifier = modifier.padding(20.dp),
            isVisible = showImagePreview,
            image = activeImage
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    PinInterestClonesTheme {
        HomeScreen(
            images = emptyList(),
            onImageClick = {}
        )
    }
}

@Preview(
    uiMode = 0x20
)
@Composable
private fun HomeScreenPreview2() {
    PinInterestClonesTheme {
        HomeScreen(
            images = emptyList(),
            onImageClick = {}
        )
    }
}