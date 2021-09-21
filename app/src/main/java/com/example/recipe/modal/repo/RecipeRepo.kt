package com.example.recipe.modal.repo

import androidx.lifecycle.MutableLiveData
import com.example.recipe.modal.dataItem.MealList
import com.example.recipe.modal.dataItem.Reciepe
import com.example.recipe.modal.reterofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeRepo(val  service:RetrofitService)
{
        var reciepe= MutableLiveData<Reciepe>()
        val recipeList  = MutableLiveData<MealList>()

        fun getReciepeList()
        {
            val response = service.getReciepeList()
            response.enqueue(object : Callback<MealList>
            {

                override fun onResponse(call: Call<MealList>?, response: Response<MealList>?)
                {
                    recipeList.postValue(response?.body())
                    println(recipeList.toString())

                }

                override fun onFailure(call: Call<MealList>?, t: Throwable?)
                {
                     println(" ")
                }

            })

        }
         fun getReciepe( id:String)
         {
             val response = service.getReciepeParticlular(id)
             response.enqueue(object : Callback<Reciepe>
             {
                 override fun onResponse(call: Call<Reciepe>?, response: Response<Reciepe>?) {
                        reciepe.postValue(response?.body())
                 }

                 override fun onFailure(call: Call<Reciepe>?, t: Throwable?) {

                 }

             })

         }
}