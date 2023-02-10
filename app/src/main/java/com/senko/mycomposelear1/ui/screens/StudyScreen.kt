package com.senko.mycomposelear1.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senko.mycomposelear1.R
import com.senko.mycomposelear1.ui.components.MyStudyTopAppBar
import com.senko.mycomposelear1.viewmodel.StudyScreenViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.senko.mycomposelear1.ui.components.MindAndZZ
import com.senko.mycomposelear1.ui.theme.SelectedContentColor
import com.senko.mycomposelear1.ui.theme.TabBackgroundColor
import com.senko.mycomposelear1.ui.theme.UnSelectedContentColor
import com.senko.mycomposelear1.viewmodel.VideoViewModel
import kotlinx.coroutines.launch

private const val TAG = "StudyScreen"

data class User(
    var name: String
)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun StudyScreen(
    navHostController: NavHostController,
    svm: StudyScreenViewModel = viewModel(),
) {
    Column {
        // 搜索 bar
        MyStudyTopAppBar {
            Row(
                Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Surface(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(16.dp))
                        .clickable {

                        },
                    color = Color(0x33FFFFFF),
                ) {
                    Row(
                        Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // 搜索框
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = stringResource(id = R.string.search),
                            Modifier.size(19.dp)
                        )
                        Text(
                            text = "搜索你感兴趣的内容",
                            fontSize = 12.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(text = "学习", color = Color.White, fontSize = 10.sp)
                    Text(text = "进度", color = Color.White, fontSize = 10.sp)
                }
                Text(
                    text = "数字",
                    color = Color.White,
                    fontSize = 10.sp,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
                BadgedBox(
                    badge = {
                        Text(
                            text = "99+",
                            color = Color.Red,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    modifier = Modifier.padding(end = 10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = stringResource(id = R.string.study_notification),
                        tint = Color.White
                    )
                }
            }
        }

        var pagerState = rememberPagerState()
        val scope = rememberCoroutineScope()
        // 分类
        Column {
            // Tab
            TabRow(
                selectedTabIndex = pagerState.currentPage,
                backgroundColor = TabBackgroundColor,
                indicator = { tabPositions ->
                    // 画一条线
                    Box(
                        Modifier
                            .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                            .height(TabRowDefaults.IndicatorHeight)
                            .background(color = MaterialTheme.colors.primary)
                    )
                }
            ) {
                svm.categories.forEachIndexed { index, category ->
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            // 需要调用pager来发生页面滑动
                            scope.launch {
                                pagerState.scrollToPage(index)
                            }
                        },
                        text = {
                            Text(text = category.title)
                        },
                        selectedContentColor = SelectedContentColor,
                        unselectedContentColor = UnSelectedContentColor,
                    )
                }
            }
            // 内容
            HorizontalPager(
                count = svm.categories.size,
                // 页面滑动所需要素
                state = pagerState,
            ) { currentPage ->
                StudyBody(svm, currentPage, navHostController)
            }
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
private fun StudyBody(viewModel: StudyScreenViewModel, currentPage: Int, navHostController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        when(viewModel.categories[currentPage].title) {
            "思想政治" -> MindAndZZ(viewModel, viewModel(), viewModel(), navHostController)
            "法律法规" -> Text(text = "法律法规")
            "经济管理" -> Text(text = "经济管理")
            "科学技术" -> Text(text = "科学技术")
        }
    }
}
