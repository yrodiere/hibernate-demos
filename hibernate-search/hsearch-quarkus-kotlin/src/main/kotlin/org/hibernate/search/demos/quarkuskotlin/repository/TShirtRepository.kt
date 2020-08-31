package org.hibernate.search.demos.quarkuskotlin.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import org.hibernate.search.demos.quarkuskotlin.orm.TShirt
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TShirtRepository : PanacheRepository<TShirt> {
    fun search(terms: String, offset: Int? = null, limit: Int? = null) =
            find("name", terms).count()
}