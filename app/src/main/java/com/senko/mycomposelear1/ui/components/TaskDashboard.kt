package com.senko.mycomposelear1.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TaskDashboard() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "学习任务",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.systemBarsPadding()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "学习周期 2021-08-01 ~ 2021-08-31", fontSize = 14.sp, color = Color.White)
            Spacer(modifier = Modifier.height(8.dp))
        }
        item {
            // 进度图
            // 圆环
            val boxWidth: Int
            with(LocalConfiguration.current) {
                boxWidth = if (screenWidthDp > 600) {
                    300
                } else {
                    200
                }
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(boxWidth.dp)
                    .height(boxWidth.dp)
            ) {
                // 圆环
                Canvas(
                    modifier = Modifier
                        .size(boxWidth.dp)
                ) {
                    rotate(180f) {
                        drawArc(
                            color = Color(0, 0, 0, 33),
                            startAngle = -10f,
                            sweepAngle = 200f,
                            useCenter = false,
                            style = Stroke(30f, cap = StrokeCap.Round)
                        )
                    }
                }
                // 白色进度
                Canvas(
                    modifier = Modifier
                        .size(boxWidth.dp)
                ) {
                    rotate(180f) {
                        drawArc(
                            color = Color.White,
                            startAngle = -10f,
                            sweepAngle = 126f,
                            useCenter = false,
                            style = Stroke(30f, cap = StrokeCap.Round)
                        )
                    }
                }

                // 进度数据
                Text(
                    text = "已完成 60%",
                    color = Color.White,
                    style = MaterialTheme.typography.h5
                )
            }
        }
        // 学习明细
        item {
            Box(
                modifier = Modifier
                    .fillParentMaxSize()
                    .padding(top = 8.dp)
                    .padding(horizontal = 8.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .background(Color.White)
            ) {
                Column(Modifier.padding(8.dp)) {
                    Text(text = "学习明细", fontSize = 16.sp, color = Color(0xFF333333))
                    Text(text = "最近一周或得到积分情况", fontSize = 14.sp, color = Color(0xFF999999))
                    Text(text = "以下是一段数据XXXXX")

                    // 进入任务提醒
                    Text(
                        text = "进入获取0积分，快去完成下面的任务吧",
                        color = Color(0xFF149EE7),
                        fontSize = 14.sp,
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0x33149EE7))
                            .padding(vertical = 8.dp)
                            .padding(8.dp)
                           .fillMaxWidth()
                    )

                    // 任务
                    DailyTaskContent()
                }
            }
        }
    }
}

