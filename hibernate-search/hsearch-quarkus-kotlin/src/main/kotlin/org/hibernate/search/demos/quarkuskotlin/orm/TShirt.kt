package org.hibernate.search.demos.quarkuskotlin.orm

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField
import javax.persistence.*

@Entity
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