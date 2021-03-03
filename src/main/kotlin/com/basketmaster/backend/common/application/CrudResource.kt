package com.basketmaster.backend.common.application

import com.basketmaster.backend.common.domain.CrudService
import com.basketmaster.backend.common.domain.Model
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.jboss.logging.Logger
import java.net.URI
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.transaction.Transactional
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.Response

interface Dto

abstract class CrudResource<D : Dto>(
    private val modelType: Class<out Model<*>>
) {

    companion object {
        private val LOG: Logger = Logger.getLogger(CrudResource::class.java)
    }

    @Inject
    @field: Default
    open lateinit var service: CrudService<out Model<*>>

    @Inject
    @field: Default
    lateinit var objectMapper: ObjectMapper

    @POST
    @Transactional
    @Consumes("application/json")
    @Produces("application/json")
    fun create(@Valid dto: D): Response {
        val data = objectMapper.convertValue(dto, object: TypeReference<Map<String, Any>>() {})
        val model = service.create(data, modelType)
        val path = this.javaClass.annotations.find { it is Path } as? Path
        return Response.created(URI.create("/${path?.value}/${model.id}")).entity(model).build()
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    fun read(@PathParam("id") id: String): Response {
        val model = service.read(id)
        return Response.ok(model).build()
    }

    fun update() {}
    fun delete() {}
    fun list() {}
    fun patch() {}
}
