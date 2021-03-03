package com.basketmaster.backend.business.application

import com.basketmaster.backend.business.domain.Exercise
import com.basketmaster.backend.business.domain.Training
import com.basketmaster.backend.common.application.CrudResource
import com.basketmaster.backend.common.application.Dto
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size
import javax.ws.rs.Path

data class TrainingDto(
    @NotBlank(message = "Title may not be blank")
    val title: String,

    @NotBlank(message = "Goals may not be blank")
    @Size(message = "Goals size may be between 1 - 5 goals ", min = 1, max = 5)
    val trainables: List<Exercise>
) : Dto

@Path("/trainings")
class TrainingResource : CrudResource<TrainingDto>(Training::class.java)
