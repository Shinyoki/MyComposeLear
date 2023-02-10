package com.senko.mycomposelear1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.senko.mycomposelear1.ui.components.MyWebView

@Composable
fun ArticleDetailScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Article Detail", modifier = Modifier.statusBarsPadding())
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "退回",
                        modifier = Modifier
                            .statusBarsPadding()
                            .clickable {
                            navHostController.popBackStack()
                        }
                    )
                }
            )
        }
    ) {
        Column(Modifier.padding(it)) {
            Text(text = "这是文章详情内容")
            MyWebView()
        }
    }
}