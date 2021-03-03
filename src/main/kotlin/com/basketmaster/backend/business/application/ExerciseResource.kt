package com.basketmaster.backend.business.application

import com.basketmaster.backend.business.domain.Exercise
import com.basketmaster.backend.common.application.CrudResource
import com.basketmaster.backend.common.application.Dto
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size
import javax.ws.rs.Path

data class ExerciseDto(
    @NotBlank(message = "Title may not be blank")
    val title: String,

    @NotBlank(message = "Description may not be blank")
    val description: String,

    @NotBlank(message = "Duration may not be blank")
    @Min(message = "Duration may not be less than 0 min", value = 0)
    @Max(message = "Duration may no be high than 60 min", value = 60)
    val duration: Int,

    @NotBlank(message = "Goals may not be blank")
    @Size(message = "Goals size may be between 1 - 5 goals ", min = 1, max = 5)
    val goals: List<String>
) : Dto

@Path("/exercises")
class ExerciseResource : CrudResource<ExerciseDto>(Exercise::class.java)
