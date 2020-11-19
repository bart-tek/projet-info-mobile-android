package com.example.henripotier.contract

import com.example.henripotier.model.Book
import com.example.henripotier.model.Offer

interface CartContractInterface {

    interface View {
        fun initView()
        fun updateViewData()
    }

    interface Presenter {
        fun getCart(): HashMap<Book, Int>
        fun removeBook(book: Book)
        fun addBook(book: Book)
        fun getTotal(): Pair<Double, Offer?>
        fun flushCart()
    }

    interface Model {
        fun getCart(): HashMap<Book, Int>
        fun removeBook(book: Book)
        fun addBook(book: Book)
        fun flushCart()
    }

}