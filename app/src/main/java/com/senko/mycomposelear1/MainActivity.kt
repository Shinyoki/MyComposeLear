package com.senko.mycomposelear1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.senko.mycomposelear1.ui.components.NavHostApp
import com.senko.mycomposelear1.ui.screens.MainFrame
import com.senko.mycomposelear1.ui.theme.MyComposeLear1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MyComposeLear1Theme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                    ,
                    color = MaterialTheme.colors.background
                ) {
                    NavHostApp()
                }
            }
        }
    }
}

