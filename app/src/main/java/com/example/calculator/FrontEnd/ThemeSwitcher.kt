package com.example.calculator.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.calculator.ui.theme.Pink
import androidx.compose.ui.graphics.Color

@Composable
fun ThemeSwitcher(
    isChecked: Boolean,
    onToggle: (Boolean) -> Unit
) {
    Switch(
        checked = isChecked,
        onCheckedChange = onToggle,
        colors = SwitchDefaults.colors(
            checkedThumbColor = Pink,
            uncheckedThumbColor = Color.White,
            checkedTrackColor = Color.DarkGray,
            uncheckedTrackColor = Pink
        )
    )
}
