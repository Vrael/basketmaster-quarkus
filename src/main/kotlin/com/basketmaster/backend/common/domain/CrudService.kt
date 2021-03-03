package com.basketmaster.backend.common.domain

import com.basketmaster.backend.common.infraestructure.CrudMongoRepository
import com.fasterxml.jackson.databind.ObjectMapper
import io.quarkus.mongodb.panache.kotlin.PanacheMongoRepository
import org.bson.types.ObjectId
import org.jboss.logging.Logger
import java.time.Instant
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject


interface CrudService<M : Model<*>> {
    fun create(params: Map<String, Any>, modelClass: Class<out Model<*>>): M
    fun read(id: String): M?
}

@ApplicationScoped
class CrudServiceImpl<M : Model<*>> : CrudService<M> {

    companion object {
        private val LOG: Logger = Logger.getLogger(CrudServiceImpl::class.java)
    }

    @Inject
    @field: Default
    lateinit var objectMapper: ObjectMapper

   /* @Inject
    @field: Default
    lateinit var repository: CrudMongoRepository<M>*/

    @Inject
    @field: Default
    lateinit var repository: PanacheMongoRepository<M>

    override fun create(params: Map<String, Any>, modelClass: Class<out Model<*>>): M {
        val now = Instant.now()
        val p = params + mapOf("creator" to "", "created" to now, "modifier" to "", "modified" to now)
        val model = objectMapper.convertValue(p, modelClass) as M
        repository.persist(model)
        return model
    }

    override fun read(id: String): M? = repository.findById(ObjectId(id))

}
