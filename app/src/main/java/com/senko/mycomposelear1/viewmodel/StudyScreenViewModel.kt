package com.senko.mycomposelear1.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.senko.mycomposelear1.R
import com.senko.mycomposelear1.model.entity.Category
import com.senko.mycomposelear1.model.entity.DataType

class StudyScreenViewModel : ViewModel() {
    // 分类数据
    var categories by mutableStateOf(
        listOf(
            Category("思想政治"),
            Category("法律法规"),
            Category("经济管理"),
            Category("科学技术"),
        )
    )

    // 轮播图类型
    val types by mutableStateOf(
        listOf(
            DataType(
                "相关资讯",
                R.drawable.baseline_description_24,
                "https://docs.bughub.icu/compose/assets/banner5.jpg"
            ),
            DataType(
                "视频课程",
                R.drawable.baseline_smart_display_24,
                "https://docs.bughub.icu/compose/assets/banner4.jpg"
            )
        )
    )

    //通知数据
    val notifications =
        listOf(
            "人社部向疫情防控期",
            "湖北黄冈新冠肺炎患者治愈病例破千连续5治愈病例破千连续5",
            "安徽单日新增确诊病例首次降至个位数累计"
        )


}