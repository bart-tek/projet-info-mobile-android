package com.example.henripotier.api

import android.content.Context
import android.content.SharedPreferences
import com.example.henripotier.model.Book
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import org.json.JSONStringer

private var PRIVATE_MODE = 0
private const val PREF_NAME = "henripotiercart"

class CartService {

    private fun updateCart(context: Context, cart: HashMap<String, Int>){
        val sharedPref: SharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        with(sharedPref.edit()){
            val json = Gson().toJson(cart)
            putString("cart", json)
            apply()
        }
    }

    fun retrieveCart(context: Context): HashMap<String, Int>{
        val sharedPref: SharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        val cartJson = sharedPref.getString("cart", "{}")
        val type = object : TypeToken<HashMap<String, Int>>() {}.type
        return try {
            let { Gson().fromJson(cartJson, type)?: HashMap() };
        } catch (e: Exception) {
            // Error while retrieving cart, removing data
            updateCart(context, HashMap())
            HashMap()
        }
    }

    fun addBook(context: Context, book: Book){
        var cart = retrieveCart(context)
        if(cart.containsKey(book.isbn)){
            cart[book.isbn!!] = cart[book.isbn]!! +1
        }
        else{
            cart[book.isbn!!] = 1
        }
        updateCart(context, cart)
    }


    fun removeBook(context: Context, book: Book){
        var cart = retrieveCart(context)
        if(cart.containsKey(book.isbn) && cart[book.isbn]!! > 1){
            cart[book.isbn!!] = cart[book.isbn]!! -1
        }
        else{
            cart.remove(book.isbn)
        }
        updateCart(context, cart)
    }
}
