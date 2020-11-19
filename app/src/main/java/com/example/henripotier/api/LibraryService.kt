package com.example.henripotier.api

import com.example.henripotier.model.Book
import com.example.henripotier.model.OfferList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LibraryService {
    // Method GET books which return a List<Book>
    @GET("books")
    fun listBooks(): Call<List<Book>>

    // Method GET discount which return a List<Offers>
    @GET("books/{isbns}/commercialOffers")
    fun getDiscounts(@Path("isbns") isbns: String): Call<OfferList>

}
