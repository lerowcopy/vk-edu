package com.example.vkedu.domain.appdetails

interface SimilarAppsRepository {
    suspend fun getSimilarApps(): List<SimilarApp>
}
