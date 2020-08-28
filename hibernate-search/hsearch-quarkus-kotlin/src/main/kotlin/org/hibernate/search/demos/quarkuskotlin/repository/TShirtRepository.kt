package org.hibernate.search.demos.quarkuskotlin.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import org.hibernate.search.demos.quarkuskotlin.orm.TShirt
import org.hibernate.search.engine.search.query.SearchResult
import org.hibernate.search.mapper.orm.Search
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TShirtRepository : PanacheRepository<TShirt> {
    fun search(terms: String, offset: Int? = null, limit: Int? = null): SearchResult<TShirt> =
            Search.session(getEntityManager()).search(TShirt::class.java)
                    .where {
                        it.simpleQueryString()
                                .fields("name", "color")
                                .matching("terms")
                    }
                    .fetch(offset, limit)
}