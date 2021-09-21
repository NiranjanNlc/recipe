package com.example.recipe.modal.reterofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

public interface RetrofitService {

    @GET("search?country=Nepal")
    fun getAllUniversity(): retrofit2.Call<List<Map<String, Any>>>

    companion object {

        var retrofitService: RetrofitService? = null

        public fun getInstance(): RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("http://universities.hipolabs.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}