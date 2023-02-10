package com.senko.mycomposelear1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.senko.mycomposelear1.model.entity.NavigationItem
import com.senko.mycomposelear1.ui.components.NavigationBarSpacer


@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainFrame(navController: NavHostController) {

    // 导航图标元素
    val bottomNavigationItems = listOf(
        NavigationItem("Study", Icons.Filled.Home),
        NavigationItem("Task", Icons.Filled.Search),
        NavigationItem("Mine", Icons.Filled.Favorite),
    )

    // 坐标
    var curNavIndex by remember {
        mutableStateOf(0)
    }

    // 底部导航栏 背景透明 文字反色
    val systemUiController = rememberSystemUiController()
//    systemUiController.setNavigationBarColor(Color.Transparent,
//        darkIcons = MaterialTheme.colors.isLight)
    Scaffold(
        bottomBar = {

            BottomNavigation(
                // 设置Navi高度
                Modifier.windowInsetsBottomHeight(
                    // 导航栏高度 加 56.dp
                    WindowInsets.navigationBars.add(WindowInsets(bottom = 56.dp))
                ),
                backgroundColor = MaterialTheme.colors.surface,
                contentColor = MaterialTheme.colors.onSurface
            ) {
                bottomNavigationItems.forEachIndexed { index, navigationItem ->
                    BottomNavigationItem(
                        selected = curNavIndex == index,
                        onClick = {
                            curNavIndex = index
                        },
                        icon = {
                            // 导航图标
                            Icon(
                                imageVector = navigationItem.icon,
                                contentDescription = navigationItem.title
                            )
                        },
                        label = {
                            Text(text = navigationItem.title)
                        },
                        selectedContentColor = Color(0xFF149EE7),
                        unselectedContentColor = Color(0xFF999999),
                        // 导航栏内部元素 向下拓宽，防止 底部导航栏遮罩 内容
                        modifier = Modifier
                            .background(MaterialTheme.colors.surface)
                            .navigationBarsPadding()
                    )
                }
            }
        },
        content = {

            Box(Modifier.padding(it)) {
                when (curNavIndex) {
                    0 -> {
                        StudyScreen(navController)
                    }
                    1 -> {
                        TaskScreen()
                    }
                    2 -> {
                        MineScreen()
                    }
                }
            }
        }
    )
}