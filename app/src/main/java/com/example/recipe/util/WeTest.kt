package com.example.recipe.util

import com.example.recipe.modal.repo.RecipeRepo
import com.example.recipe.modal.reterofit.RetrofitService
import com.example.recipe.viewmodal.ReciepeViewModal
import com.example.recipe.viewmodal.ViewModalFactory

fun main()
{
    val repository = RecipeRepo(RetrofitService.getInstance())
     val sampleViewModal= ViewModalFactory( repository).create(ReciepeViewModal::class.java)
     sampleViewModal.getReciepeList()
    println(" this data "+ sampleViewModal.reciepList.toString())
}
class WeTest
{

}