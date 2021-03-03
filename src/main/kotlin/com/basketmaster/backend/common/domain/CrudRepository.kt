package com.basketmaster.backend.common.domain

interface CrudRepository<M : Model<*>> {
    fun save(model: M): M
    fun findById(id: String): M
}
