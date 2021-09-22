package com.example.recipe.modal.reterofit

import com.example.recipe.modal.dataItem.Meal
import com.example.recipe.modal.dataItem.MealList
import com.example.recipe.modal.dataItem.MealX
import com.example.recipe.modal.dataItem.Reciepe
import com.example.recipe.util.BaseUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import okhttp3.Interceptor
import retrofit2.http.Path


public interface RetrofitService {

    @GET("feeds/list?start=0&limit=18&tag=list.recipe.popular")
    fun getReciepe(): retrofit2.Call<List<Map<String, Any>>>
    @GET("filter.php?a=Indian")
    fun getReciepeList(): retrofit2.Call<MealList>
    @GET("search.php")
    fun getReciepeParticlular( @Path("i") reciepe: String?): retrofit2.Call<Reciepe>


    companion object {

        var retrofitService: RetrofitService? = null

        public fun getInstance(): RetrofitService {

            if (retrofitService == null) {
                retrofitService = createReterofit()
            }
            return retrofitService!!
        }

        private fun createReterofit(): RetrofitService
        {
            val retrofit = Retrofit.Builder()
                .baseUrl(BaseUrl.FOODMEALAPI.url)
                .addConverterFactory(GsonConverterFactory.create())
                //.client(createHttPRequest())
                .build()
            return retrofit.create(RetrofitService::class.java)
        }


        private fun createHttPRequest(): OkHttpClient {
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor { chain ->
                val request = chain.request().
                newBuilder()
                .addHeader("x-rapidapi-host", "yummly2.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "undefined")
                .addHeader("parameter", "value").
                build()
                chain.proceed(request)
            }

            return httpClient.build()

        }

    }
}