package com.example.calculator.FrontEnd

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.Pink

@Composable
fun FeatureRow() {
    val itemsList = listOf("Basic", "Scientific", "Unit Conversion", "Etc")

    LazyRow(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(itemsList) { item ->
            Button(
                onClick = { /* handle click */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                modifier = Modifier
                    .border(width = 2.dp, color = Pink, shape = CircleShape)
            ) {
                Text(text = item, color = Pink, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
