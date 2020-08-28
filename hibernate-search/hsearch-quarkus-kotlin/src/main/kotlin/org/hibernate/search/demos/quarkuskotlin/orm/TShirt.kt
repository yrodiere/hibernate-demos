package org.hibernate.search.demos.quarkuskotlin.orm

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed
import javax.persistence.*

@Entity
@Indexed
class TShirt {
    @Id
    @GeneratedValue
    var id: Long? = null

    @FullTextField(analyzer = "english")
    lateinit var name: String

    @FullTextField(analyzer = "english")
    @Enumerated(EnumType.STRING)
    lateinit var color: Color
}