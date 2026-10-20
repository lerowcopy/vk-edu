package com.example.vkedu.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ShoppingCart

/** Захардкоженные данные для экрана «Список приложений». */
val sampleApps: List<AppInfo> = listOf(
    AppInfo(
        id = 1,
        name = "ВКонтакте",
        description = "Лента новостей, сообщения, сообщества и музыка в одном приложении",
        category = "Соцсети",
        icon = Icons.Filled.Face,
    ),
    AppInfo(
        id = 2,
        name = "Telegram",
        description = "Быстрый мессенджер с чатами, каналами и ботами",
        category = "Мессенджеры",
        icon = Icons.AutoMirrored.Filled.Send,
    ),
    AppInfo(
        id = 3,
        name = "Яндекс Карты",
        description = "Маршруты, пробки и общественный транспорт в реальном времени",
        category = "Навигация",
        icon = Icons.Filled.Place,
    ),
    AppInfo(
        id = 4,
        name = "Яндекс Музыка",
        description = "Миллионы треков, подборки и персональные рекомендации",
        category = "Музыка",
        icon = Icons.Filled.PlayArrow,
    ),
    AppInfo(
        id = 5,
        name = "Сбербанк Онлайн",
        description = "Переводы, платежи, управление картами и вкладами",
        category = "Финансы",
        icon = Icons.Filled.Lock,
    ),
    AppInfo(
        id = 6,
        name = "Ozon",
        description = "Маркетплейс с быстрой доставкой и удобным возвратом товаров",
        category = "Покупки",
        icon = Icons.Filled.ShoppingCart,
    ),
    AppInfo(
        id = 7,
        name = "Календарь",
        description = "События, напоминания и расписание на неделю",
        category = "Продуктивность",
        icon = Icons.Filled.DateRange,
    ),
    AppInfo(
        id = 8,
        name = "Почта",
        description = "Единый ящик для всех ваших e-mail аккаунтов",
        category = "Почта",
        icon = Icons.Filled.Email,
    ),
    AppInfo(
        id = 9,
        name = "Заметки",
        description = "Быстрые записи, списки дел и черновики",
        category = "Продуктивность",
        icon = Icons.Filled.Edit,
    ),
    AppInfo(
        id = 10,
        name = "Фитнес",
        description = "Шаги, тренировки и сон: цели и статистика за неделю",
        category = "Здоровье",
        icon = Icons.Filled.Favorite,
    ),
)