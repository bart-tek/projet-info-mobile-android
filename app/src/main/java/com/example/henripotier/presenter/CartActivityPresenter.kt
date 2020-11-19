package com.example.henripotier.presenter

import com.example.henripotier.api.RetrofitBuilder.apiService
import com.example.henripotier.contract.CartContractInterface.*
import com.example.henripotier.model.Book
import com.example.henripotier.model.CartActivityModel
import com.example.henripotier.model.Offer
import com.example.henripotier.model.OfferList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber


class CartActivityPresenter(_view: View) : Presenter {

    private var view: View = _view
    private var model: Model = CartActivityModel()
    private var total: Double = 0.0
    private var discount: Offer? = null

    init {
        view.initView()
        initTotal()
    }

    override fun getCart(): HashMap<Book, Int> {
        return model.getCart()
    }

    private fun initTotal() {
        val cart = model.getCart()
        val isbns = cart.keys.map { b -> b.isbn }
        val booksRequest = apiService.getDiscounts(isbns = isbns.joinToString(","))

        for ((book, amount) in model.getCart()) {
            total += book.price!!.toInt() * amount
        }

        booksRequest.enqueue(object : Callback<OfferList> {
            override fun onResponse(call: Call<OfferList>, response: Response<OfferList>) {
                val allOffers = response.body()?.offers
                discount = Offer.bestOffer(allOffers, total)
                view.updateViewData()
            }

            override fun onFailure(call: Call<OfferList>, t: Throwable) {
                Timber.e(t)
            }
        })
    }

    override fun removeBook(book: Book) {
        model.removeBook(book)
        view.updateViewData()
    }

    override fun addBook(book: Book) {
        model.addBook(book)
        view.updateViewData()
    }

    override fun getTotal(): Pair<Double, Offer?> {
        return Pair(total, discount)
    }


    override fun flushCart() {
        TODO("Not yet implemented")
    }


}