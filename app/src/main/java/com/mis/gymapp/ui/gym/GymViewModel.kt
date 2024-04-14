package com.mis.gymapp.ui.gym

import androidx.lifecycle.ViewModel
import com.mis.gymapp.data.providers.GymProvider
import com.mis.gymapp.domain.model.GymInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class GymViewModel @Inject constructor(gymProvider: GymProvider): ViewModel() {

    private var _exercise = MutableStateFlow<List<GymInfo>>(emptyList())
    val exercise: StateFlow<List<GymInfo>> = _exercise
    init {
        _exercise.value = gymProvider.getExercises()
    }
}