package com.example.recipe.modal.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter

@Entity(tableName = "reciepe")
data class RecipeItem(
    val imageURL: String,
    val ingredients: List<Ingredient>,
    @PrimaryKey
    val name: String,
    val originalURL: String,
    val steps: List<String>,
    val timers: List<Int>
)