package com.example.henripotier.presenter

import android.content.Intent
import com.example.henripotier.contract.BookDetailsContract
import com.example.henripotier.model.Book
import com.example.henripotier.model.BookDetailsActivityModel
import com.example.henripotier.view.BookDetailsActivity

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

    override fun getSynopsis(): List<String> = model.getSynopsis()

    override fun getIsbn(): String = model.getIsbn()

}