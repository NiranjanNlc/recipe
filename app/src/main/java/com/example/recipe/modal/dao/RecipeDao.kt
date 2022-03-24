package com.example.recipe.modal.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.example.recipe.modal.data.RecipeItem

@Dao
interface RecipeDao {
    @Insert(onConflict = REPLACE)
    fun save(recipe: RecipeItem)

    @Update
    fun update(recipe: RecipeItem)

    @Query("SELECT * FROM  reciepe ORDER BY name ASC")
    fun getAlphabetizedWords(): LiveData<List<RecipeItem>>

}