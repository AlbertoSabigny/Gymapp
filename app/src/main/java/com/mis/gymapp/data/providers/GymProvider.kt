package com.mis.gymapp.data.providers

import com.mis.gymapp.domain.model.GymInfo
import com.mis.gymapp.domain.model.GymInfo.Sentadilla
import javax.inject.Inject

//obtenemos la lista del modelo
class GymProvider @Inject constructor(){
    fun getExercises(): List<GymInfo>{
        return listOf(
            GymInfo.Press,
            GymInfo.Curl,
            Sentadilla,
            GymInfo.Press2,
            GymInfo.Curl3

        )
    }
}