package com.example.henripotier.presenter

import android.content.Intent
import com.example.henripotier.contract.BookDetailsContract
import com.example.henripotier.model.Book
import com.example.henripotier.model.BookDetailsActivityModel
import com.example.henripotier.view.BookDetailsActivity
import java.lang.StringBuilder

class BookDetailsActivityPresenter(_view: BookDetailsContract.View, intent : Intent): BookDetailsContract.Presenter {

    companion object {
        private const val BOOK = "BOOK"
    }

    private var view: BookDetailsContract.View = _view
    private var model: BookDetailsContract.Model = BookDetailsActivityModel()

    init {
        model.setBook(intent.extras?.get(BOOK) as Book)
    }

    override fun getTitle(): String = model.getTitle()

    override fun getPrice(): String = model.getPrice()

    override fun getCover(): String = model.getCover()

    override fun getSynopsis(): String {

        val synopsisAsList = model.getSynopsis()
        var synopsisBuilder = StringBuilder()

        for (line in synopsisAsList!!) {
            synopsisBuilder.append(line)
            synopsisBuilder.append("\n")
            synopsisBuilder.append("\n")
        }

        return synopsisBuilder.dropLast(1) .toString()
    }

    override fun getIsbn(): String = model.getIsbn()

}