package com.example.vkedu.data.appdetails

import com.example.vkedu.domain.appdetails.SimilarApp
import com.example.vkedu.domain.appdetails.SimilarAppsRepository

class SimilarAppsRepositoryImpl(
    private val api: SimilarAppsApi,
    private val mapper: SimilarAppMapper,
) : SimilarAppsRepository {
    override suspend fun getSimilarApps(): List<SimilarApp> =
        api.getSimilarApps().map(mapper::toDomain)
}
