package com.mis.gymapp.domain

import com.mis.gymapp.data.network.response.ExcerciseResponse
import com.mis.gymapp.domain.model.ExerciseModel

interface Repository {
    suspend fun getExercises(id: String): ExerciseModel?
}