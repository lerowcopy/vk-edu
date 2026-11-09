package com.example.vkedu.domain.applist

class GetShowcaseAppsUseCase(
    private val repository: AppListRepository,
) {
    suspend operator fun invoke(): List<AppInfo> = repository.getShowcaseApps()
}
