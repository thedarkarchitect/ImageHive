package com.example.pininterestclones.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pininterestclones.ui.theme.PinInterestClonesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior,
    title: String
) {
    var color = if(isSystemInDarkTheme()) Color.White else Color.Black
    CenterAlignedTopAppBar(
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        title = {
            Box {
                Column {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 35.sp,
                        color = color
                    )
                    Canvas(
                        modifier = modifier
                            .fillMaxWidth(fraction = 0.11f)
                    ) {
                        drawLine(
                            color = color,
                            start = Offset(0f, 0f),
                            end = Offset(size.width, 0f),
                            strokeWidth = 5.dp.toPx(),
                            cap = StrokeCap.Round
                        )
                    }
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            scrolledContainerColor = MaterialTheme.colorScheme.background
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview()
@Composable
private fun TopPreview() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    PinInterestClonesTheme {
        TopAppBar(
            scrollBehavior = scrollBehavior,
            title = "All"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(uiMode = 0x20)
@Composable
private fun TopPreview2() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    PinInterestClonesTheme {
        TopAppBar(
            scrollBehavior = scrollBehavior,
            title = "All"
        )
    }
}