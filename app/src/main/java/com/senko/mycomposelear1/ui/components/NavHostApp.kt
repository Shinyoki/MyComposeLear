package com.senko.mycomposelear1.ui.components

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.senko.mycomposelear1.ui.navigation.Destinations
import com.senko.mycomposelear1.ui.screens.ArticleDetailScreen
import com.senko.mycomposelear1.ui.screens.MainFrame

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavHostApp() {
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = Destinations.HomeFrame.route
    ) {
        // 首页
        composable(
            Destinations.HomeFrame.route,
            enterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Right)
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Left)
            }
        ) {
            MainFrame(navController)
        }
        // 文章详情
        composable(
            Destinations.ArticleDetail.route,
            enterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Left)
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Right)
            }
        ) {
            ArticleDetailScreen(navController)
        }
    }
}