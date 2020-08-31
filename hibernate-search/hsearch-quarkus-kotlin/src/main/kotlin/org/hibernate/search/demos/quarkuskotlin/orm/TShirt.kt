package org.hibernate.search.demos.quarkuskotlin.orm

import javax.persistence.*

@Entity
open class TShirt() {
    @Id
    @GeneratedValue
    var id: Long? = null

    lateinit var name: String

}