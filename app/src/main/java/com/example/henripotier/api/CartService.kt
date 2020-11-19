package com.example.henripotier.api

import android.content.Context
import android.content.SharedPreferences
import com.example.henripotier.model.Book
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

private var PRIVATE_MODE = 0
private const val PREF_NAME = "henripotiercart"

class CartService {

    fun updateCart(context: Context, cart: HashMap<Book, Int>){
        val sharedPref: SharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        with(sharedPref.edit()){
            val json = Gson().toJson(cart)
            putString("cart", json)
            apply()
        }
    }

    fun retrieveCart(context: Context): HashMap<Book, Int>{
        val sharedPref: SharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        val cartJson = sharedPref.getString("cart", "")
        val type = object : TypeToken<HashMap<Book, Int>>() {}.type
        return  Gson().fromJson(cartJson, type)
    }

    fun addBook(context: Context, book: Book){
        var cart = retrieveCart(context)
        if(cart.containsKey(book)){
            cart[book] = cart[book]!! +1
        }
        else{
            cart[book] = 1
        }
        updateCart(context, cart)
    }
}
