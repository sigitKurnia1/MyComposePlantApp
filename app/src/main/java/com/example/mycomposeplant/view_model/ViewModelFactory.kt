package com.example.mycomposeplant.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mycomposeplant.data.PlantRepository

class ViewModelFactory(private val plantRepository: PlantRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModelScreen::class.java)) {
            return HomeViewModelScreen(plantRepository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModelScreen::class.java)) {
            return DetailViewModelScreen(plantRepository) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class with name: ${modelClass.name}")
        }
    }
}