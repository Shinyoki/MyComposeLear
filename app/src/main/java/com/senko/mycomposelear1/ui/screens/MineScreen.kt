package com.senko.mycomposelear1.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senko.mycomposelear1.R

@Composable
fun MineScreen() {
    val menuItems = listOf(
        MenuItem(R.drawable.baseline_sports_baseball_24, "学习积分"),
        MenuItem(R.drawable.baseline_browser_updated_24, "浏览记录"),
        MenuItem(R.drawable.baseline_browser_updated_24, "学习档案"),
        MenuItem(R.drawable.baseline_browser_updated_24, "场景问题"),
        MenuItem(R.drawable.baseline_browser_updated_24, "版本信息"),
        MenuItem(R.drawable.baseline_browser_updated_24, "联系我们"),

    )
    Column(
        Modifier
            .fillMaxSize()
    ) {
        TopAppBar(
            modifier = Modifier.height(70.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.systemBarsPadding(),
                    text = "我的",
                    fontSize = 18.sp,
                    color = Color.White
                )
            }
        }
        LazyColumn {
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "头像",
                        modifier = Modifier
                            .size(62.dp)
                            .clip(CircleShape)
                    )
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        Text(text = "未登录", color = Color(0xFF333333), fontSize = 18.sp)
                        Text(text = "已坚持学习0天", color = Color(0xFF999999), fontSize = 12.sp)
                    }
                }
            }
            items(menuItems.size) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = menuItems[it].icon),
                        contentDescription = "头像",
                        modifier = Modifier
                            .size(24.dp)
                    )
                    Text(
                        text = menuItems[it].title,
                        color = Color(0xFF333333),
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}

data class MenuItem(
    @DrawableRes val icon: Int,
    val title: String
)