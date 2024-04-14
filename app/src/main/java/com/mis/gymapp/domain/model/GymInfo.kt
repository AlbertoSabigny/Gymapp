package com.mis.gymapp.domain.model

import com.mis.gymapp.R

sealed class GymInfo(val img:Int, val name: Int){
    data object Press: GymInfo(R.drawable.barra, R.string.press)
    data object Sentadilla: GymInfo(R.drawable.sentadilla, R.string.sentadilla)
    data object Curl: GymInfo(R.drawable.curl, R.string.curl)
    data object Press2: GymInfo(R.drawable.barra, R.string.press)
    data object Curl3: GymInfo(R.drawable.curl, R.string.curl)

}