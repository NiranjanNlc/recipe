package com.example.recipe.util

import com.example.recipe.modal.dataItem.Meal

object InstructionFormatter {
    fun formatInstruction(meal: Meal) {
        for (prop in meal::class.members) {
            println("${prop.name} = ${meal}")
        }
    }

}
