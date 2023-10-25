package com.example.mycomposeplant.data

import com.example.mycomposeplant.model.Plant
import com.example.mycomposeplant.model.PlantData

class PlantRepository {
    fun getPlants(): List<Plant> {
        return PlantData.plant
    }

    fun searchPlants(query: String): List<Plant> {
        return PlantData.plant.filter { plant ->
            plant.plantName.contains(query, ignoreCase = true)
        }
    }

    fun getPlantById(id: String): Plant {
        return PlantData.plant.find {
            it.id == id
        } as Plant
    }
}