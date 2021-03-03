package com.basketmaster.backend.business.domain

import com.basketmaster.backend.common.domain.Auditable
import com.basketmaster.backend.common.domain.Model
import io.quarkus.mongodb.panache.MongoEntity
import org.bson.types.ObjectId
import java.time.Instant

@MongoEntity(collection = "trainings")
class Training(
    var title: String,
    var trainables: List<Exercise>,
    override var creator: String,
    override var created: Instant,
    override var modifier: String,
    override var modified: Instant,
    override var id: ObjectId?,
) : Model<ObjectId>, Auditable
