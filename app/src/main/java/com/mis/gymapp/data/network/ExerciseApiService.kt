package com.mis.gymapp.data.network

import com.mis.gymapp.data.network.response.ExcerciseResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ExerciseApiService {

    @GET("exercises/exercise/{id}")
    suspend fun getExercises(
        @Path("id") id: String
    ):ExcerciseResponse


}