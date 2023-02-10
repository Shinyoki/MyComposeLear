package com.senko.mycomposelear1.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senko.mycomposelear1.model.entity.ArticleEntity

@Composable
fun ArticleItem(articleEntity: ArticleEntity, modifier: Modifier) {
    Column(
        modifier = modifier
            .padding(10.dp)
    ) {
        Text(
            text = articleEntity.title,
            modifier = Modifier
                .height(50.dp),
            maxLines = 2,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Row {
            Text(text = articleEntity.source)
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = articleEntity.timestamp)
        }
    }
}