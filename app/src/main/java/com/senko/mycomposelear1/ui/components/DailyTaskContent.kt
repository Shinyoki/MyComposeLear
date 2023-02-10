package com.senko.mycomposelear1.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DailyTaskContent() {
    DailyTaskItem(mainTitle = "文章学习", subTitle = "学习内容", curPoints = 50)
    DailyTaskItem(mainTitle = "单词背诵", subTitle = "学习内容", curPoints = 50)
}

@Composable
fun DailyTaskItem(mainTitle: String, subTitle: String, curPoints: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .height(40.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
        ) {
            Text(text = mainTitle, fontSize = 16.sp, color = Color(0xFF333333))
            Row {
                Text(text = "10积分/每有效阅读1篇文章")
                Icon(imageVector = Icons.Rounded.Info, contentDescription = "详情")
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                LinearProgressIndicator(progress = .2f)
                Text(text = "20/100", Modifier.weight(7f))
            }
        }
        Column {
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "已完成", fontSize = 16.sp, color = Color(0xFF333333))
            }
        }
    }

    Divider(modifier = Modifier.padding(vertical = 8.dp))
}