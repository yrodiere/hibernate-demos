package org.hibernate.search.demos.quarkuskotlin.dto

import com.github.pozo.KotlinBuilder
import org.hibernate.search.demos.quarkuskotlin.orm.Color
import org.hibernate.search.demos.quarkuskotlin.orm.TShirt
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget
import javax.json.bind.annotation.JsonbCreator

@Mapper
interface TShirtMapper {
    fun toDto(source: TShirt): TShirtRetrieveDto
    fun fromDto(@MappingTarget target: TShirt, dto: TShirtCreateUpdateDto)
}

@KotlinBuilder
data class TShirtCreateUpdateDto @JsonbCreator constructor(val name: String, val color: Color)
@KotlinBuilder
data class TShirtRetrieveDto(val id: Long, val name: String, val color: Color)
