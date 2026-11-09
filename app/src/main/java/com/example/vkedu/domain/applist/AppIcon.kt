package com.example.vkedu.domain.applist

/**
 * Иконка приложения на уровне domain.
 *
 * Domain ничего не знает про Compose, поэтому вместо ImageVector здесь enum.
 * В ImageVector его превращает слой presentation (см. AppIconMapper.kt).
 */
enum class AppIcon {
    FACE,
    SEND,
    PLACE,
    PLAY,
    LOCK,
    CART,
    CALENDAR,
    EMAIL,
    EDIT,
    FAVORITE,
    SEARCH,
    LOCATION,
    INFO,
    ACCOUNT,
    THUMB_UP,
    HOME,
    BUILD,
    DEFAULT,
}
