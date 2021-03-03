package com.basketmaster.backend.business.application

import com.basketmaster.backend.business.domain.Player
import com.basketmaster.backend.business.domain.Season
import com.basketmaster.backend.business.domain.Team
import com.basketmaster.backend.common.application.CrudResource
import com.basketmaster.backend.common.application.Dto
import javax.validation.constraints.NotBlank
import javax.ws.rs.Path

data class TeamDto(
    @NotBlank(message = "Title may not be blank")
    val title: String,
    var description: String? = null,
    var league: String? = null,
    var logo: String? = null,
    var season: Season? = null,
    var players: List<Player>? = null,
) : Dto

@Path("/teams")
class TeamResource : CrudResource<TeamDto>(Team::class.java)
