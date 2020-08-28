package org.hibernate.search.demos.quarkuskotlin.dto

import com.github.pozo.KotlinBuilder
import org.hibernate.search.demos.quarkuskotlin.orm.Color
import org.hibernate.search.demos.quarkuskotlin.orm.TShirt
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget

@Mapper
interface TShirtMapper {
    fun toDto(source: TShirt): TShirtRetrieveDto
    fun fromDto(@MappingTarget target: TShirt, dto: TShirtCreateUpdateDto);
}

@KotlinBuilder
data class TShirtCreateUpdateDto(val name: String, val color: Color)
@KotlinBuilder
data class TShirtRetrieveDto(val id: Int, val name: String, val color: Color)
