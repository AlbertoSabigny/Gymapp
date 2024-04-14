package com.mis.gymapp.ui.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mis.gymapp.domain.usescase.GetExerciseUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GymDetailViewModel @Inject constructor(private val getExerciseUserCase: GetExerciseUserCase): ViewModel(){
    private var _state = MutableStateFlow<GymDetailState>(GymDetailState.Loading)
    val state:StateFlow<GymDetailState> =  _state

    private var excercise: String =""

    fun getExcercise(id: String){
        excercise = id
        println(id)
        viewModelScope.launch {
            try {
                _state.value=GymDetailState.Loading
                val result = withContext(Dispatchers.IO){getExerciseUserCase(id)}
                Log.d("API_RESULT", "Result: $result")
                if (result!=null){
                    _state.value= GymDetailState.Sucess(result.bodyPart, result.equipment, result.gifUrl,
                        result.name, result.target, id)
                }else{
                    _state.value = GymDetailState.Error("ha ocurrido un error")

                }
            } catch (e: Exception){
                Log.e("API_ERROR", "Error: ${e.message}")
            }

        }

    }
}//