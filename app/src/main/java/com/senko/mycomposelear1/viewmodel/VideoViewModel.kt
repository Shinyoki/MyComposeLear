package com.senko.mycomposelear1.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.senko.mycomposelear1.model.entity.VideoEntity

class VideoViewModel: ViewModel() {
    val list by mutableStateOf(
        listOf(
            VideoEntity(
                title = "行测老师告诉你如何制定适合自己的学习方案",
                type = "视频课程",
                duration = "00:02:00",
                imageUrl = "https://docs.bughub.icu/compose/assets/banner1.webp"
            ),
            VideoEntity(
                title = "行测老师告诉你如何制定适合自己的学习方案",
                type = "视频课程",
                duration = "00:02:00",
                imageUrl = "https://docs.bughub.icu/compose/assets/banner2.webp"
            ),
            VideoEntity(
                title = "行测老师告诉你如何制定适合自己的学习方案",
                type = "视频课程",
                duration = "00:02:00",
                imageUrl = "https://docs.bughub.icu/compose/assets/banner3.webp"
            ),
            VideoEntity(
                title = "行测老师告诉你如何制定适合自己的学习方案",
                type = "视频课程",
                duration = "00:02:00",
                imageUrl = "https://docs.bughub.icu/compose/assets/banner4.jpg"
            ),
            VideoEntity(
                title = "行测老师告诉你如何制定适合自己的学习方案",
                type = "视频课程",
                duration = "00:02:00",
                imageUrl = "https://docs.bughub.icu/compose/assets/banner5.jpg"
            ),
            VideoEntity(
                title = "行测老师告诉你如何制定适合自己的学习方案",
                type = "视频课程",
                duration = "00:02:00",
                imageUrl = "https://docs.bughub.icu/compose/assets/banner1.webp"
            ),
            VideoEntity(
                title = "行测老师告诉你如何制定适合自己的学习方案",
                type = "视频课程",
                duration = "00:02:00",
                imageUrl = "https://docs.bughub.icu/compose/assets/banner1.webp"
            ),
            VideoEntity(
                title = "行测老师告诉你如何制定适合自己的学习方案",
                type = "视频课程",
                duration = "00:02:00",
                imageUrl = "https://docs.bughub.icu/compose/assets/banner1.webp"
            )
        )
    )
}