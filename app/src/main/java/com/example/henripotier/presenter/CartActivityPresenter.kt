package com.example.henripotier.presenter

import com.example.henripotier.contract.CartContractInterface.*
import com.example.henripotier.model.Book
import com.example.henripotier.model.CartActivityModel


class CartActivityPresenter(_view: View): Presenter {

    private var view: View = _view
    private var model: Model = CartActivityModel()

    init {
        view.initView()
    }

    override fun getCart(): HashMap<Book, Int> {
       return model.getCart()
    }

    override fun removeBook(book: Book) {
        model.removeBook(book)
        view.updateViewData()
    }

    override fun addBook(book: Book) {
        model.addBook(book)
        view.updateViewData()
    }

    override fun getTotal(): Double {
        var total:Double = 0.0
        for ((book, amount) in model.getCart()) {
           total += book.price.toInt() *amount
        }
        return total
    }


}