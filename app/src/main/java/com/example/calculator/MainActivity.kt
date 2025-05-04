package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import com.example.calculator.FrontEnd.HomePage
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var isDarkMode by remember { mutableStateOf(false) }

            CalculatorTheme(darkTheme = isDarkMode) {
                HomePage(
                    isDarkMode = isDarkMode,
                    onThemeToggle = { newValue ->
                        isDarkMode = newValue
                    }
                )
            }
        }
    }
}
