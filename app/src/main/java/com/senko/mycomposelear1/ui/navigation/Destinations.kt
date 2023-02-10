package com.senko.mycomposelear1.ui.navigation

sealed class Destinations(
    val route: String
) {
    object HomeFrame: Destinations("homeFrame")
    object ArticleDetail: Destinations("articleDetail")
}