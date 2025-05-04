package com.example.calculator.FrontEnd

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.example.calculator.R
import com.example.calculator.ui.components.ThemeSwitcher
import com.example.calculator.ui.theme.Pink
import evaluateExpression

@Composable
fun HomePage(
    isDarkMode: Boolean, // Use the state from MainActivity
    onThemeToggle: (Boolean) -> Unit // Handle theme toggle
) {
    var InputValue by remember { mutableStateOf("") }
    var HistoryValue by remember { mutableStateOf("") }

    val backgroundColor = if (isDarkMode) Color.Black else Color.White


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 8.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp, bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FeatureRow()
        }

        // Show history above input
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalAlignment = Alignment.End
        ) {
            if (HistoryValue.isNotBlank()) {
                Text(
                    text = HistoryValue,
                    fontSize = 26.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 50.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis    // Add overflow handling
                )
            }

            Spacer(Modifier.height(12.dp))

            Text(
                text = InputValue,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Pink,
                lineHeight = 50.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis    // Add overflow handling
            )
        }

        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Update theme toggle using the parent state
                ThemeSwitcher(isChecked = isDarkMode) { newValue ->
                    onThemeToggle(newValue) // Use onThemeToggle to update the state in MainActivity
                }
                Image(
                    painter = painterResource(id = R.drawable.backspace),
                    contentDescription = "Delete Button",
                    colorFilter = ColorFilter.tint(Pink),
                    modifier = Modifier
                        .size(70.dp)
                        .clickable {
                            InputValue = if (InputValue.isNotEmpty()) {
                                InputValue.dropLast(1)
                            } else {
                                ""
                            }
                        }
                )
            }

            HorizontalDivider(thickness = 1.dp)

            GridButton { value ->
                when (value) {
                    "AC" -> {
                        InputValue = ""
                        HistoryValue = ""
                    }
                    "=" -> {
                        try {
                            HistoryValue = InputValue
                            val result = evaluateExpression(InputValue)
                            InputValue = result
                        } catch (e: Exception) {
                            InputValue = "Error"
                        }
                    }
                    else -> InputValue += value
                }
            }
        }
    }
}
