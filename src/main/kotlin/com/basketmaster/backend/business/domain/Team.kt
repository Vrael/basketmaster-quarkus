package com.basketmaster.backend.business.domain

import com.basketmaster.backend.common.domain.Auditable
import com.basketmaster.backend.common.domain.Model
import io.quarkus.mongodb.panache.MongoEntity
import org.bson.types.ObjectId
import java.time.Instant
import java.time.LocalDate

data class Season(val start: LocalDate? = null, val end: LocalDate? = null)
data class Player(
    var fullname: String,
    var photo: String? = null,
    var number: Int? = null,
    var height: Float? = null,
    var weight: Float? = null,
    var birthdate: LocalDate? = null,
    var position: String? = null
)

@MongoEntity(collection = "teams")
class Team(
    var title: String,
    override var creator: String,
    override var created: Instant,
    override var modifier: String,
    override var modified: Instant,
    var description: String? = null,
    var league: String? = null,
    var logo: String? = null,
    var season: Season? = null,
    var players: List<Player>? = null,
    override var id: ObjectId?,
) : Model<ObjectId>, Auditable
