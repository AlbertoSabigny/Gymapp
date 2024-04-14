package com.mis.gymapp.data

import android.util.Log
import com.google.gson.annotations.SerializedName
import com.mis.gymapp.data.network.ExerciseApiService
import com.mis.gymapp.domain.Repository
import com.mis.gymapp.domain.model.ExerciseModel
import javax.inject.Inject
//El error inicia aqui
class ExerciseRepositoryImpl @Inject constructor(private val apiService: ExerciseApiService ):Repository  {
    override suspend fun getExercises(id: String): ExerciseModel? {
        //llamamos a retrofit
        println("aqui hay error")
        runCatching { apiService.getExercises(id) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("sabigsa", "ocurrio un error f ${it.message}") }
        return null
    }
}
