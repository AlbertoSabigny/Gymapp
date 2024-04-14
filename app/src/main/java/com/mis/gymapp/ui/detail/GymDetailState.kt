package com.mis.gymapp.ui.detail

sealed class GymDetailState {
    data object Loading : GymDetailState()
    data class Error(val error: String) : GymDetailState()
    data class Sucess(
        val bodyPart: String,
        val equipment: String,
        val gifUrl: String,
        val name: String,
        val target: String,
        val id: String

    ) : GymDetailState()

}