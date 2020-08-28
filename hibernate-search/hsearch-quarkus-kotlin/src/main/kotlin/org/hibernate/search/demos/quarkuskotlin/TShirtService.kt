package org.hibernate.search.demos.quarkuskotlin

import org.hibernate.search.demos.quarkuskotlin.dto.TShirtMapper
import org.hibernate.search.demos.quarkuskotlin.repository.TShirtRepository
import org.jboss.resteasy.annotations.jaxrs.QueryParam
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/tshirt")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class TShirtService(
        @Inject private val repository: TShirtRepository,
        @Inject private val mapper: TShirtMapper
) {

    @GET
    @Path("/search")
    fun search(@QueryParam terms: String, @QueryParam offset: Int = 0, @QueryParam limit: Int = 20) =
            repository.search(terms, offset, limit)

}