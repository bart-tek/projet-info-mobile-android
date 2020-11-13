package com.example.henripotier.contract

import com.example.henripotier.model.Book

interface LibraryContractInterface {

    interface View {
        fun initView()
        fun updateViewData()
    }

    interface Presenter {
        fun getBookList() : List<Book>
    }

    interface Model {
        fun getBookList() : List<Book>
        fun setBookList(booklist : List<Book>)
    }

}