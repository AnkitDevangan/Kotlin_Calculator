package com.example.calculator.FrontEnd

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GridButton(onButtonClick: (String) -> Unit) {
    val gridItems = listOf(
        listOf("AC", "^2", "%", "÷"),
        listOf("7", "8", "9", "×"),
        listOf("4", "5", "6", "-"),
        listOf("1", "2", "3", "+"),
        listOf("00", "0", ".", "=")
    )

    val containerColor = Color(0xffb5aaaf)
    val numColor = Color(0xff302c2b)
    val specificNumColor = Color(0xffd1528b)

    val cornerRadius = 24.dp // Increased corner radius for more rounded buttons

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        gridItems.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                row.forEach { item ->
                    val backgroundColor = when (item) {
                        "=" -> specificNumColor
                        else -> containerColor
                    }

                    val textColor = when (item) {
                        "AC", "^2", "%", "÷", "+", "-", "×" -> specificNumColor
                        "=" -> Color.White
                        else -> numColor
                    }

                    val mappedValue = when (item) {
                        "%" -> "%"   // Percent sign
                        "÷" -> "/"    // Division
                        "+" -> "+"    // Addition
                        "-" -> "-"    // Subtraction
                        "×" -> "*"    // Multiplication
                        "=" -> "="    // Equals sign (for calculation)
                        else -> item  // For numbers and other buttons
                    }

                    Button(
                        onClick = { onButtonClick(mappedValue) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = backgroundColor,
                            contentColor = textColor
                        ),
                        shape = RoundedCornerShape(cornerRadius),
                        contentPadding = PaddingValues(0.dp), // Remove default padding
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f) // Make buttons perfect squares
                    ) {
                        // Center the text both horizontally and vertically
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(
                                text = item,
                                fontSize = 26.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}