package com.example.vkedu.data

import kotlinx.coroutines.delay

class AppListRepositoryImpl : AppListRepository {

    override suspend fun getApps(): List<AppInfo> {
        delay(LOADING_DELAY_MS)
        return sampleApps
    }

    private companion object {
        const val LOADING_DELAY_MS = 1_000L
    }
}
