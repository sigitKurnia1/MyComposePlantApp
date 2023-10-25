package com.example.mycomposeplant.view_model

import androidx.lifecycle.ViewModel
import com.example.mycomposeplant.data.PlantRepository
import com.example.mycomposeplant.model.Plant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModelScreen(private val plantRepository: PlantRepository) : ViewModel() {
    fun getPlantData(plantId: String): StateFlow<Plant> = MutableStateFlow(
        plantRepository.getPlantById(plantId)
    ).asStateFlow()
}