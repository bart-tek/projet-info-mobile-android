package com.example.henripotier.api

import com.example.henripotier.model.Book
import retrofit2.Call
import retrofit2.http.GET

interface LibraryService {
    // Method GET books which return a List<Book>
    @GET("books")
    fun listBooks(): Call<List<Book>>

}
