package org.hibernate.search.demos.quarkuskotlin

import org.hibernate.search.demos.quarkuskotlin.dto.SearchResultDto
import org.hibernate.search.demos.quarkuskotlin.dto.TShirtCreateUpdateDto
import org.hibernate.search.demos.quarkuskotlin.dto.TShirtMapper
import org.hibernate.search.demos.quarkuskotlin.dto.TShirtRetrieveDto
import org.hibernate.search.demos.quarkuskotlin.orm.TShirt
import org.hibernate.search.demos.quarkuskotlin.repository.TShirtRepository
import org.jboss.resteasy.annotations.jaxrs.PathParam
import org.jboss.resteasy.annotations.jaxrs.QueryParam
import javax.inject.Inject
import javax.transaction.Transactional
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/tshirt")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
class TShirtService(
        @Inject val repository: TShirtRepository,
        @Inject val mapper: TShirtMapper
) {

    @PUT
    @Path("/")
    fun create(data: TShirtCreateUpdateDto): TShirtRetrieveDto {
        val tshirt = TShirt()
        mapper.fromDto(tshirt, data)
        repository.persist(tshirt)
        return mapper.toDto(tshirt)
    }

    @POST
    @Path("/{id}/")
    fun update(@PathParam id: Long, data: TShirtCreateUpdateDto): TShirtRetrieveDto? {
        val tshirt = repository.findById(id) ?: throw NotFoundException()
        mapper.fromDto(tshirt, data)
        repository.persist(tshirt)
        return mapper.toDto(tshirt)
    }

    @POST
    @Path("/{id}/")
    fun retrieve(@PathParam id: Long, data: TShirtCreateUpdateDto): TShirtRetrieveDto? {
        val tshirt = repository.findById(id) ?: throw NotFoundException()
        return mapper.toDto(tshirt)
    }

    @GET
    @Path("/search")
    fun search(@QueryParam terms: String, @QueryParam offset: Int = 0, @QueryParam limit: Int = 20) =
            SearchResultDto.from(repository.search(terms, offset, limit), mapper::toDto)

}