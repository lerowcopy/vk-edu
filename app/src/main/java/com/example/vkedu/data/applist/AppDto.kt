package com.example.vkedu.data.applist

/**
 * DTO — данные в том виде, в котором их отдаёт источник (сервер / заглушка).
 * Из data-слоя наружу не выходит: в domain попадает только через [AppInfoMapper].
 *
 * [icon] — строковый ключ иконки, как он пришёл бы с сервера.
 */
data class AppDto(
    val id: Int,
    val name: String,
    val description: String,
    val category: String,
    val icon: String,
)
