package com.senko.mycomposelear1.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.senko.mycomposelear1.ui.theme.Blue500
import com.senko.mycomposelear1.ui.theme.Blue700

@Composable
fun MyStudyTopAppBar(
    content: @Composable () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.linearGradient(
                    listOf(
                        Blue700,
                        Blue500
                    )
                )
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.statusBarsPadding()) {
            content()
        }
    }
}

@Preview
@Composable
fun PreviewTop() {
    MyStudyTopAppBar {
        Text(text = "标题")
    }
}