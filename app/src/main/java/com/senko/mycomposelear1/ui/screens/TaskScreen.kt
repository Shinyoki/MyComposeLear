package com.senko.mycomposelear1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.senko.mycomposelear1.ui.components.TaskDashboard
import com.senko.mycomposelear1.ui.theme.Blue200
import com.senko.mycomposelear1.ui.theme.Blue700

@Composable
fun TaskScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    listOf(Blue700, Blue200)
                )
            )
    ) {
        // 学习任务Top Dashboard
        TaskDashboard()
    }
}