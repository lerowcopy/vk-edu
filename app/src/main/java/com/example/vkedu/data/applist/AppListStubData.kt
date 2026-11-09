package com.example.vkedu.data.applist

/** Захардкоженные данные для экрана «Список приложений». */
internal val sampleAppDtos: List<AppDto> = listOf(
    AppDto(
        id = 1,
        name = "ВКонтакте",
        description = "Лента новостей, сообщения, сообщества и музыка в одном приложении",
        category = "Соцсети",
        icon = "face",
    ),
    AppDto(
        id = 2,
        name = "Telegram",
        description = "Быстрый мессенджер с чатами, каналами и ботами",
        category = "Мессенджеры",
        icon = "send",
    ),
    AppDto(
        id = 3,
        name = "Яндекс Карты",
        description = "Маршруты, пробки и общественный транспорт в реальном времени",
        category = "Навигация",
        icon = "place",
    ),
    AppDto(
        id = 4,
        name = "Яндекс Музыка",
        description = "Миллионы треков, подборки и персональные рекомендации",
        category = "Музыка",
        icon = "play",
    ),
    AppDto(
        id = 5,
        name = "Сбербанк Онлайн",
        description = "Переводы, платежи, управление картами и вкладами",
        category = "Финансы",
        icon = "lock",
    ),
    AppDto(
        id = 6,
        name = "Ozon",
        description = "Маркетплейс с быстрой доставкой и удобным возвратом товаров",
        category = "Покупки",
        icon = "cart",
    ),
    AppDto(
        id = 7,
        name = "Календарь",
        description = "События, напоминания и расписание на неделю",
        category = "Продуктивность",
        icon = "calendar",
    ),
    AppDto(
        id = 8,
        name = "Почта",
        description = "Единый ящик для всех ваших e-mail аккаунтов",
        category = "Почта",
        icon = "email",
    ),
    AppDto(
        id = 9,
        name = "Заметки",
        description = "Быстрые записи, списки дел и черновики",
        category = "Продуктивность",
        icon = "edit",
    ),
    AppDto(
        id = 10,
        name = "Фитнес",
        description = "Шаги, тренировки и сон: цели и статистика за неделю",
        category = "Здоровье",
        icon = "favorite",
    ),
)

/**
 * Захардкоженные данные для блока «Витрина»:
 * ровно 9 приложений = 3 страницы по 3 приложения.
 */
internal val showcaseAppDtos: List<AppDto> = listOf(
    // Страница 1
    AppDto(
        id = 101,
        name = "VK Видео",
        description = "Фильмы, сериалы и ролики на любой вкус в одном приложении",
        category = "Видео",
        icon = "play",
    ),
    AppDto(
        id = 102,
        name = "Авито",
        description = "Объявления о товарах, услугах и недвижимости рядом с вами",
        category = "Покупки",
        icon = "search",
    ),
    AppDto(
        id = 103,
        name = "2ГИС",
        description = "Карты, адреса организаций и маршруты по городу",
        category = "Навигация",
        icon = "location",
    ),
    // Страница 2
    AppDto(
        id = 104,
        name = "Госуслуги",
        description = "Документы, штрафы и запись к врачу без очередей",
        category = "Сервисы",
        icon = "info",
    ),
    AppDto(
        id = 105,
        name = "Т-Банк",
        description = "Карты, переводы и кешбэк в одном приложении",
        category = "Финансы",
        icon = "account",
    ),
    AppDto(
        id = 106,
        name = "Дзен",
        description = "Персональная лента статей, видео и подкастов",
        category = "Новости",
        icon = "thumb_up",
    ),
    // Страница 3
    AppDto(
        id = 107,
        name = "Самокат",
        description = "Доставка продуктов и товаров для дома за 15 минут",
        category = "Еда",
        icon = "home",
    ),
    AppDto(
        id = 108,
        name = "Кинопоиск",
        description = "Рейтинги, подборки и новинки кино и сериалов",
        category = "Кино",
        icon = "thumb_up",
    ),
    AppDto(
        id = 109,
        name = "Сканер документов",
        description = "Быстро сканируйте бумаги и сохраняйте их в PDF",
        category = "Утилиты",
        icon = "build",
    ),
)
