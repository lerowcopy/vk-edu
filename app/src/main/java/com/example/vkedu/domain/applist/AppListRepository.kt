package com.example.vkedu.domain.applist

interface AppListRepository {
    /** Приложения для экрана «Список приложений». */
    suspend fun getApps(): List<AppInfo>

    /** Приложения для блока «Витрина» на карточке приложения. */
    suspend fun getShowcaseApps(): List<AppInfo>
}
