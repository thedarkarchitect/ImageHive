package com.example.pininterestclones

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pininterestclones.presentation.components.TopAppBar
import com.example.pininterestclones.presentation.navigation.NavGraph
import com.example.pininterestclones.presentation.navigation.Routes
import com.example.pininterestclones.ui.theme.PinInterestClonesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayoutScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

//    val context = LocalContext.current.applicationContext

    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            if(selected.value == Icons.Default.Home){
                TopAppBar(
                    scrollBehavior = scrollBehavior,
                    title = "All"
                )
            }
        },
        bottomBar = {
            BottomAppBar(
                containerColor = if(isSystemInDarkTheme()) Color.Black else Color.LightGray
            ) {
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Home
                        navController.navigate(Routes.HomeScreen.screen)
                    },
                    modifier = modifier.weight(1f)){
                    Icon(
                        Icons.Default.Home,
                        contentDescription = null,
                        modifier = modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Search
                        navController.navigate(Routes.SearchScreen.screen)
                    },
                    modifier = modifier.weight(1f)){
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null,
                        modifier = modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Search) Color.White else Color.DarkGray
                    )
                }
            }
        }
    ) {
        NavGraph(
            modifier = Modifier.padding(it),
            navController = navController
        )
    }
}

@Preview
@Composable
private fun LayoutPreview() {
    PinInterestClonesTheme {
        LayoutScreen(navController = rememberNavController())
    }
}

@Preview(
    uiMode = 0x20
)
@Composable
private fun LayoutPreview2() {
    PinInterestClonesTheme {
        LayoutScreen(navController = rememberNavController())
    }
}