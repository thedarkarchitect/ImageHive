package com.example.pininterestclones.presentation.home_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pininterestclones.domain.model.ImageItem
import com.example.pininterestclones.presentation.components.ImageVerticalGrid
import com.example.pininterestclones.ui.theme.PinInterestClonesTheme


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    images: List<ImageItem>,
    onImageClick: (String) -> Unit
) {
        ImageVerticalGrid(
            images = images,
            onImageClick = onImageClick
        )
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