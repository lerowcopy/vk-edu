package com.example.vkedu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.vkedu.navigation.AppNavGraph
import com.example.vkedu.ui.theme.VkEduTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Цвет иконок статус-бара задаёт каждый экран сам (см. StatusBarIcons)
        enableEdgeToEdge()

        setContent {
            VkEduTheme {
                AppNavGraph()
            }
        }
    }
}
