package com.example.recipe.modal.data

import androidx.room.Entity

@Entity
data class RecipeItem(
    val imageURL: String,
    val ingredients: List<Ingredient>,
    val name: String,
    val originalURL: String,
    val steps: List<String>,
    val timers: List<Int>
)