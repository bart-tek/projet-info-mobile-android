package com.example.henripotier.contract

import com.example.henripotier.model.Book

interface CartContractInterface {

    interface View {
        fun initView()
        fun updateViewData()
    }

    interface Presenter {
        fun getCart() : HashMap<Book, Int>
        fun removeBook(book: Book)
        fun addBook(book:Book)
        fun getTotal(): Double
    }

    interface Model {
        fun getCart() : HashMap<Book, Int>
        fun removeBook(book: Book)
        fun addBook(book:Book)
    }

}