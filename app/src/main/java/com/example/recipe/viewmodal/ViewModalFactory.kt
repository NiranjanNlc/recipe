package com.example.recipe.viewmodal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recipe.modal.repo.RecipeRepo

class ViewModalFactory(private val repository:RecipeRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        println(" Inn view odal factory")
        if (modelClass.isAssignableFrom(ReciepeViewModal::class.java)) {
            println("Assighnabke class")
            @Suppress("UNCHECKED_CAST")
            return  ReciepeViewModal(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
