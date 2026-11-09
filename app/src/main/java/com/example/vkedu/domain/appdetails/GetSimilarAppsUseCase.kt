package com.example.vkedu.domain.appdetails

class GetSimilarAppsUseCase(
    private val repository: SimilarAppsRepository,
) {
    suspend operator fun invoke(): List<SimilarApp> = repository.getSimilarApps()
}
