package com.example.mycomposeplant.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mycomposeplant.data.PlantRepository
import com.example.mycomposeplant.model.Plant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModelScreen(private val plantRepository: PlantRepository) : ViewModel() {
    private val _groupedPlants = MutableStateFlow(
        plantRepository.getPlants()
            .sortedBy { it.plantName }
            .groupBy { it.plantName[0] }
    )
    val groupedPlants: StateFlow<Map<Char, List<Plant>>> get() = _groupedPlants

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedPlants.value = plantRepository.searchPlants(newQuery)
            .sortedBy { it.plantName }
            .groupBy { it.plantName[0] }
    }
}