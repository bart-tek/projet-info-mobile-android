package com.example.henripotier.api

import com.example.henripotier.model.BookModel
import retrofit2.Call
import retrofit2.http.GET

interface LibraryService {
    // TODO Method GET books which return a List<Book>
    @GET("books")
    fun listBooks(): Call<Array<BookModel>>

}
