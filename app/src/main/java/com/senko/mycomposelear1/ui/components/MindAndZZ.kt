package com.senko.mycomposelear1.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import com.senko.mycomposelear1.model.entity.VideoEntity
import com.senko.mycomposelear1.ui.navigation.Destinations
import com.senko.mycomposelear1.ui.theme.SelectedContentColor
import com.senko.mycomposelear1.viewmodel.ArticleViewModel
import com.senko.mycomposelear1.viewmodel.StudyScreenViewModel
import com.senko.mycomposelear1.viewmodel.VideoViewModel
import kotlinx.coroutines.launch
import java.util.*

private const val TAG = "MindAndZZ"

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MindAndZZ(svm: StudyScreenViewModel,
              avm: ArticleViewModel,
              vvm: VideoViewModel = viewModel(),
              navHostController: NavHostController
) {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    // 通知
    val noticeState = rememberPagerState()
    LazyColumn(
    ) {

        // 轮播图
        item() {
            TabRow(
                selectedTabIndex = pagerState.currentPage,
                backgroundColor = Color.Transparent,
                contentColor = SelectedContentColor,
                indicator = {},
                divider = {},
            ) {
                svm.types.forEachIndexed { index, dataType ->
                    LeadingIconTab(
                        unselectedContentColor = Color.Gray,
                        selected = pagerState.currentPage == index,
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        text = {
                            Text(
                                text = dataType.title,
                                fontSize = 14.sp
                            )
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = dataType.iconResourceId),
                                contentDescription = dataType.title
                            )
                        }
                    )
                }
            }
        }
        item() {
            // 轮播图
            HorizontalPager(
                count = 2,
                state = pagerState,
                modifier = Modifier
                    .padding(9.dp),
                itemSpacing = 10.dp
            ) {
                AsyncImage(
                    model = svm.types[it].imgUrl,
                    contentDescription = svm.types[it].title,
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .fillMaxWidth()
                        .aspectRatio(7 / 3f),
                    contentScale = ContentScale.Crop
                )
            }
        }
        item {
            // 轮播通知
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .height(45.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .background(Color(0xFFF1F8FF))
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "最新活动", color = Color(0xFF3F97D7), fontSize = 16.sp)
                Spacer(modifier = Modifier.width(10.dp))
                VerticalPager(
                    count = svm.notifications.size,
                    state = noticeState,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = svm.notifications[it],
                        maxLines = 1,
                        color = Color.Black,
                        fontSize = 14.sp,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "更多", color = Color.Gray, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(10.dp))
        }


        // 新闻
        if (pagerState.currentPage == 0) {
            items(count = avm.articleList.size) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    ArticleItem(avm.articleList[it], modifier = Modifier.clickable {
                        navHostController.navigate(Destinations.ArticleDetail.route)
                    })
                }
            }
        } else {
            // 视频内容
            items(count = vvm.list.size) {
                VideoItem(videoEntity = vvm.list[it])
            }
        }


    }
}

@Composable
private fun VideoItem(videoEntity: VideoEntity) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        AsyncImage(
            model = videoEntity.imageUrl,
            contentDescription = videoEntity.title,
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .size(100.dp)
                .padding(horizontal = 8.dp)
                .aspectRatio(7 / 3f),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .weight(3f)
                .padding(8.dp)
        ) {
            Text(text = videoEntity.title, fontSize = 16.sp)
            Row {
                Text(text = videoEntity.type, fontSize = 14.sp)
                Text(text = videoEntity.duration, fontSize = 14.sp)
            }
        }
    }
}