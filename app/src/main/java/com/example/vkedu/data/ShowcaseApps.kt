package com.example.vkedu.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbUp

/**
 * Захардкоженные данные для блока «Витрина»:
 * ровно 9 приложений = 3 страницы по 3 приложения.
 */
val showcaseApps: List<AppInfo> = listOf(
    // Страница 1
    AppInfo(
        id = 101,
        name = "VK Видео",
        description = "Фильмы, сериалы и ролики на любой вкус в одном приложении",
        category = "Видео",
        icon = Icons.Filled.PlayArrow,
    ),
    AppInfo(
        id = 102,
        name = "Авито",
        description = "Объявления о товарах, услугах и недвижимости рядом с вами",
        category = "Покупки",
        icon = Icons.Filled.Search,
    ),
    AppInfo(
        id = 103,
        name = "2ГИС",
        description = "Карты, адреса организаций и маршруты по городу",
        category = "Навигация",
        icon = Icons.Filled.LocationOn,
    ),
    // Страница 2
    AppInfo(
        id = 104,
        name = "Госуслуги",
        description = "Документы, штрафы и запись к врачу без очередей",
        category = "Сервисы",
        icon = Icons.Filled.Info,
    ),
    AppInfo(
        id = 105,
        name = "Т-Банк",
        description = "Карты, переводы и кешбэк в одном приложении",
        category = "Финансы",
        icon = Icons.Filled.AccountCircle,
    ),
    AppInfo(
        id = 106,
        name = "Дзен",
        description = "Персональная лента статей, видео и подкастов",
        category = "Новости",
        icon = Icons.Filled.ThumbUp,
    ),
    // Страница 3
    AppInfo(
        id = 107,
        name = "Самокат",
        description = "Доставка продуктов и товаров для дома за 15 минут",
        category = "Еда",
        icon = Icons.Filled.Home,
    ),
    AppInfo(
        id = 108,
        name = "Кинопоиск",
        description = "Рейтинги, подборки и новинки кино и сериалов",
        category = "Кино",
        icon = Icons.Filled.ThumbUp,
    ),
    AppInfo(
        id = 109,
        name = "Сканер документов",
        description = "Быстро сканируйте бумаги и сохраняйте их в PDF",
        category = "Утилиты",
        icon = Icons.Filled.Build,
    ),
)
