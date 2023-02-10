package com.senko.mycomposelear1.ui.theme

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Color
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView

private val DarkColorPalette = darkColors(
    primary = Blue500,
    primaryVariant = Blue700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Blue500,
    primaryVariant = Blue700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun MyComposeLear1Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    ApplyBarColor(darkTheme = true)
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun ApplyBarColor(darkTheme: Boolean) {
    val view = LocalView.current
    val activity = LocalContext.current as Activity
    // 每次recompose成功时都会调用该函数
    SideEffect {
        view.context.findActivity().window.apply {
            statusBarColor = Color.TRANSPARENT
            navigationBarColor = Color.TRANSPARENT
        }
    }
}

fun Context.findActivity(): Activity = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> error("Failed to find activity: ${this.javaClass.name}")
}