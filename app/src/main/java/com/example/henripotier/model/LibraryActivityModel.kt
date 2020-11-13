package com.example.henripotier.model

import com.example.henripotier.contract.LibraryContractInterface.Model


class LibraryActivityModel: Model {

    private var bookList : List<Book> = emptyList()

    override fun getBookList(): List<Book> {
        return bookList
    }

    override fun setBookList(bookList : List<Book>) {
        this.bookList = bookList
    }


}