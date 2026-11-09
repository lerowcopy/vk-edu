package com.example.vkedu.domain.applist

/**
 * Доменная модель элемента списка приложений.
 * Не зависит ни от Compose, ни от формата данных в источнике.
 */
data class AppInfo(
    val id: Int,
    val name: String,
    val description: String,
    val category: String,
    val icon: AppIcon,
)
