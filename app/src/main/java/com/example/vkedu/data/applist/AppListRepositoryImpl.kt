package com.example.vkedu.data.applist

import com.example.vkedu.domain.applist.AppInfo
import com.example.vkedu.domain.applist.AppListRepository

class AppListRepositoryImpl(
    private val api: AppListApi,
    private val mapper: AppInfoMapper,
) : AppListRepository {

    override suspend fun getApps(): List<AppInfo> =
        mapper.toDomain(api.getApps())

    override suspend fun getShowcaseApps(): List<AppInfo> =
        mapper.toDomain(api.getShowcaseApps())
}
