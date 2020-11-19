package com.example.henripotier.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBuilder {

    private const val BASE_URL = "http://henri-potier.xebia.fr/"

    private fun getRetrofit(): Retrofit {
        // Log calls from retrofit
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()


         var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
             .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build() //Doesn't require the adapter

        return retrofit
    }

    val apiService: LibraryService = getRetrofit().create(LibraryService::class.java)
}