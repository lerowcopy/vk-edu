package com.example.vkedu.data.appdetails

import com.example.vkedu.domain.appdetails.SimilarApp

class SimilarAppMapper {
    fun toDomain(dto: SimilarAppDto): SimilarApp = SimilarApp(
        id = dto.id,
        name = dto.name,
        iconUrl = dto.iconUrl,
    )
}
