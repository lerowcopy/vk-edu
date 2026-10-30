package com.example.vkedu.data

interface AppListRepository {
    suspend fun getApps(): List<AppInfo>
}
