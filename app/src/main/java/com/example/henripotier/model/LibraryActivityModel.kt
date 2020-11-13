package com.example.henripotier.model

import com.example.henripotier.contract.LibraryContractInterface.Model


class LibraryActivityModel: Model {

    private var bookList : List<BookModel> = emptyList()

    override fun getBookList(): List<BookModel> {
        return bookList
    }

    override fun setBookList(bookList : List<BookModel>) {
        this.bookList = bookList
    }


}