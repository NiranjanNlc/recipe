package com.example.recipe.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recipe.R
import com.example.recipe.modal.repo.RecipeRepo
import com.example.recipe.modal.reterofit.RetrofitService
import com.example.recipe.viewmodal.ReciepeViewModal
import com.example.recipe.viewmodal.ViewModalFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository = RecipeRepo(RetrofitService.getInstance())
        val sampleViewModal= ViewModalFactory( repository).create(ReciepeViewModal::class.java)
        sampleViewModal.getReciepeList()
        println(" this data "+ sampleViewModal.reciepList.toString())
    }
}