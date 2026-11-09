package com.example.vkedu.domain.applist

class GetAppsUseCase(
    private val repository: AppListRepository,
) {
    suspend operator fun invoke(): List<AppInfo> = repository.getApps()
}
