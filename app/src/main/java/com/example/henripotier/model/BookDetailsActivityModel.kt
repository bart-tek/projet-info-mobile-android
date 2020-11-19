package com.example.henripotier.model

import com.example.henripotier.contract.BookDetailsContract
import java.util.ArrayList

class BookDetailsActivityModel: BookDetailsContract.Model {

    private lateinit var book : Book

    override fun getTitle(): String {
        return book.title?:""
    }

    override fun getIsbn(): String {
        return book.isbn?:""
    }

    override fun getPrice(): String {
        return book.price?:""
    }

    override fun getCover(): String {
        return book.cover?:""
    }

    override fun getSynopsis(): ArrayList<String>? {
        return book.synopsis
    }

    override fun getBook() : Book {
        return book
    }

    override fun setBook(book : Book) {
        this.book = book
    }
}