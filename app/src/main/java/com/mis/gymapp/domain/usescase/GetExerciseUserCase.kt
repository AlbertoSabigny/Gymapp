package com.mis.gymapp.domain.usescase

import com.mis.gymapp.domain.Repository
import javax.inject.Inject

class GetExerciseUserCase @Inject constructor(private val repository:Repository) {

    suspend operator fun invoke(id:String) = repository.getExercises(id)
}