package com.mis.gymapp.data.network.response

import android.util.Log
import com.google.gson.annotations.SerializedName
import com.mis.gymapp.domain.model.ExerciseModel

data class ExcerciseResponse (
    @SerializedName("name")val name:String,
    @SerializedName("target")val target:String,
    @SerializedName("bodyPart")val bodyPart:String,
    @SerializedName("equipment")val equipment:String,
    @SerializedName("gifUrl")val gifUrl:String,

){
    fun toDomain():ExerciseModel{
        Log.d("API_MAPPING", "Mapping ExerciseResponse to ExerciseModel: $this")
        return ExerciseModel(name = name, target=target, bodyPart=bodyPart,
            equipment=equipment, gifUrl=gifUrl)
    }
}


