package com.example.henripotier.contract

import com.example.henripotier.model.BookModel

interface LibraryContractInterface {

    interface View {
        fun initView()
        fun updateViewData()
    }

    interface Presenter {
        fun getBookList() : List<BookModel>
    }

    interface Model {
        fun getBookList() : List<BookModel>
        fun setBookList(booklist : List<BookModel>)
    }

}