package com.example.vkedu.data

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Модель элемента списка приложений.
 */
data class AppInfo(
    val id: Int,
    val name: String,
    val description: String,
    val category: String,
    val icon: ImageVector,
)