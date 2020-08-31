package org.hibernate.search.demos.quarkuskotlin.orm

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import javax.persistence.*

@Entity
open class TShirt : PanacheEntity() {

    lateinit var name: String

}