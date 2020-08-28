package org.hibernate.search.demos.quarkuskotlin

import io.quarkus.runtime.StartupEvent
import io.quarkus.runtime.configuration.ProfileManager
import org.hibernate.search.mapper.orm.Search
import javax.enterprise.event.Observes
import javax.inject.Inject
import javax.persistence.EntityManagerFactory
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class AdminService(
        @Inject private val entityManagerFactory: EntityManagerFactory
) {

    @POST
    @Path("/reindex")
    fun reindex() = Search.mapping(entityManagerFactory).scope(Object::class.java)
            .massIndexer()
            .startAndWait()

    fun reindexOnStart(@Observes event: StartupEvent) {
        if ("dev" == ProfileManager.getActiveProfile()) {
            reindex()
        }
    }
}