package com.example.recipe.modal.data

import androidx.room.TypeConverter
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class ConverterClass {
    @TypeConverter
    fun ingredientlistToJson(value: List<Ingredient>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToingredientList(value: String) =
        Gson().fromJson(value, Array<Ingredient>::class.java).toList()

    @TypeConverter
    fun stringlistToJson(value: List<String>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToStringList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()

    @TypeConverter
    fun intlistToJson(value: List<Int>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonTointList(value: String) = Gson().fromJson(value, Array<Int>::class.java).toList()
}