package com.example.vkedu.data.applist

import kotlinx.coroutines.delay

/**
 * Заглушка источника данных: имитирует сетевой запрос и отдаёт DTO.
 * Когда появится настоящий бэкенд, заменится на Retrofit/Ktor-клиент —
 * остальные слои этого не заметят.
 */
class AppListApi {

    suspend fun getApps(): List<AppDto> {
        delay(LOADING_DELAY_MS)
        return sampleAppDtos
    }

    suspend fun getShowcaseApps(): List<AppDto> = showcaseAppDtos

    private companion object {
        const val LOADING_DELAY_MS = 1_000L
    }
}
