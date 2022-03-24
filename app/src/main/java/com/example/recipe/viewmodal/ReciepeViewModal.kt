package com.example.recipe.viewmodal

import androidx.lifecycle.ViewModel
import com.example.recipe.modal.repo.RecipeRepo

class ReciepeViewModal(val repository: RecipeRepo) : ViewModel() {
    val reciepList = repository.recipeList
    val reciepe = repository.reciepe

    init {
        repository.getReciepeList()
        println(" messsages initated ................")
    }

    fun getReciepeList() {
        repository.getReciepeList()
    }

    fun getReciepeParticular(id: String) {
        repository.getReciepe(id)
    }
}