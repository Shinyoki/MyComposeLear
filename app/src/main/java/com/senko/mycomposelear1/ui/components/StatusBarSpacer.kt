package com.senko.mycomposelear1.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun StatusBarSpacer() {
    Spacer(
        modifier = Modifier
            .statusBarsPadding()//设置状态栏高度
            .fillMaxWidth()
    )
}

@Composable
fun NavigationBarSpacer() {
    Spacer(
        modifier = Modifier
            .navigationBarsPadding()//设置导航栏高度
            .fillMaxWidth()
    )
}