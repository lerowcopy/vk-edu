package com.example.vkedu.presentation.applist

import com.example.vkedu.domain.applist.AppIcon
import com.example.vkedu.domain.applist.AppInfo

/** Данные только для @Preview — presentation не должен лезть в data. */
internal val previewApps: List<AppInfo> = listOf(
    AppInfo(
        id = 1,
        name = "ВКонтакте",
        description = "Лента новостей, сообщения, сообщества и музыка в одном приложении",
        category = "Соцсети",
        icon = AppIcon.FACE,
    ),
    AppInfo(
        id = 2,
        name = "Telegram",
        description = "Быстрый мессенджер с чатами, каналами и ботами",
        category = "Мессенджеры",
        icon = AppIcon.SEND,
    ),
    AppInfo(
        id = 3,
        name = "Яндекс Карты",
        description = "Маршруты, пробки и общественный транспорт в реальном времени",
        category = "Навигация",
        icon = AppIcon.PLACE,
    ),
    AppInfo(
        id = 4,
        name = "Яндекс Музыка",
        description = "Миллионы треков, подборки и персональные рекомендации",
        category = "Музыка",
        icon = AppIcon.PLAY,
    ),
    AppInfo(
        id = 5,
        name = "Сбербанк Онлайн",
        description = "Переводы, платежи, управление картами и вкладами",
        category = "Финансы",
        icon = AppIcon.LOCK,
    ),
    AppInfo(
        id = 6,
        name = "Ozon",
        description = "Маркетплейс с быстрой доставкой и удобным возвратом товаров",
        category = "Покупки",
        icon = AppIcon.CART,
    ),
)
