package com.example.henripotier.contract

import android.content.Context
import com.example.henripotier.model.Book
import com.example.henripotier.model.Offer

interface CartContractInterface {

    interface View {
        fun initView()
        fun updateViewData()
    }

    interface Presenter {
        fun getCart(): Map<Book?, Int>
        fun removeBook(book: Book, context: Context)
        fun addBook(book: Book, context: Context)
        fun getTotal(): Pair<Double, Offer?>
        fun flushCart(context: Context)
    }

    interface Model {
        fun getCart(): HashMap<String, Int>
        fun removeBook(book: String)
        fun addBook(book: String)
        fun setCart(cart:HashMap<String, Int>)
    }

}