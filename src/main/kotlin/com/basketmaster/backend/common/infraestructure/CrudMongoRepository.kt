package com.basketmaster.backend.common.infraestructure

import com.basketmaster.backend.common.domain.CrudRepository
import com.basketmaster.backend.common.domain.Model
import io.quarkus.mongodb.panache.kotlin.PanacheMongoRepository
import org.bson.types.ObjectId
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.NotFoundException


/*@ApplicationScoped
class CrudMongoRepository<M : Model<*>> : CrudRepository<M>, PanacheMongoRepository<M> {

    override fun save(model: M): M {
        persistOrUpdate(model)
        return model
    }

    override fun findById(id: String): M {
        val optional = super.findByIdOptional(ObjectId(id))
        return optional.orElseThrow { NotFoundException() }
    }

}*/

@ApplicationScoped
class CrudMongoRepository<M : Model<*>> : PanacheMongoRepository<M> {

    fun save(model: M): M {
        persistOrUpdate(model)
        return model
    }

}
