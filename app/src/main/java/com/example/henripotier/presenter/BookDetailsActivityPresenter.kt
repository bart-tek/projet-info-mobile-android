package com.example.henripotier.presenter

import android.content.Intent
import android.os.Bundle
import com.example.henripotier.contract.BookDetailsContract
import com.example.henripotier.contract.LibraryContractInterface
import com.example.henripotier.model.Book
import com.example.henripotier.model.BookDetailsActivityModel
import com.example.henripotier.model.LibraryActivityModel
import java.lang.StringBuilder

class BookDetailsActivityPresenter(_view: BookDetailsContract.View, bundle : Bundle?): BookDetailsContract.Presenter {



    companion object {
        private const val BOOK = "BOOK"
    }
    private var view: BookDetailsContract.View = _view
    private var model: BookDetailsContract.Model = BookDetailsActivityModel()

    init {
        bundle?.getParcelable<Book>(BOOK)?.let { book ->
            model.setBook(book)
        }
    }

    override fun getTitle(): String = model.getTitle()

    override fun getPrice(): String = model.getPrice()

    override fun getCover(): String = model.getCover()

    override fun getSynopsis(): String {

        val synopsisAsList = model.getSynopsis()
        var synopsisBuilder = StringBuilder()

        if (synopsisAsList != null) {
            for (line in synopsisAsList) {
                synopsisBuilder.append(line)
                synopsisBuilder.append("\n")
                synopsisBuilder.append("\n")
            }
        }

        return synopsisBuilder.dropLast(2) .toString()
    }

    override fun getIsbn(): String = model.getIsbn()

    override fun getBook(): Book = model.getBook()
}