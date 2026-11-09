package com.example.vkedu.data.applist

import com.example.vkedu.domain.applist.AppIcon
import com.example.vkedu.domain.applist.AppInfo

/** Конвертирует [AppDto] (data) в [AppInfo] (domain). */
class AppInfoMapper {

    fun toDomain(dto: AppDto): AppInfo = AppInfo(
        id = dto.id,
        name = dto.name,
        description = dto.description,
        category = dto.category,
        icon = mapIcon(dto.icon),
    )

    fun toDomain(dtoList: List<AppDto>): List<AppInfo> = dtoList.map { toDomain(it) }

    // Неизвестный ключ не должен ронять экран — подставляем иконку по умолчанию
    private fun mapIcon(key: String): AppIcon = when (key) {
        "face" -> AppIcon.FACE
        "send" -> AppIcon.SEND
        "place" -> AppIcon.PLACE
        "play" -> AppIcon.PLAY
        "lock" -> AppIcon.LOCK
        "cart" -> AppIcon.CART
        "calendar" -> AppIcon.CALENDAR
        "email" -> AppIcon.EMAIL
        "edit" -> AppIcon.EDIT
        "favorite" -> AppIcon.FAVORITE
        "search" -> AppIcon.SEARCH
        "location" -> AppIcon.LOCATION
        "info" -> AppIcon.INFO
        "account" -> AppIcon.ACCOUNT
        "thumb_up" -> AppIcon.THUMB_UP
        "home" -> AppIcon.HOME
        "build" -> AppIcon.BUILD
        else -> AppIcon.DEFAULT
    }
}
