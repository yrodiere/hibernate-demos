package org.hibernate.search.demos.quarkuskotlin.orm

import javax.persistence.*

@Entity
class TShirt() {
    @Id
    @GeneratedValue
    var id: Long? = null

    lateinit var name: String

    lateinit var color: Color
}