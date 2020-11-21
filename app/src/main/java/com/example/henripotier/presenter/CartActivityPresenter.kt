package com.example.henripotier.presenter

import android.content.Context
import com.example.henripotier.api.CartService
import com.example.henripotier.api.RetrofitBuilder.apiService
import com.example.henripotier.contract.CartContractInterface.*
import com.example.henripotier.model.Book
import com.example.henripotier.model.Cart
import com.example.henripotier.model.Offer
import com.example.henripotier.model.OfferList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber


class CartActivityPresenter(_view: View, context: Context) : Presenter {

    private var view: View = _view
    private var model: Model = Cart()
    private var cartService: CartService = CartService()
    private var total: Double = 0.0
    private var discount: Offer? = null
    private var bookList : Map<String, Book>? = null

    init {
        view.initView()
        model.setCart(cartService.retrieveCart(context = context))
        initBookList()
    }


    private fun initBookList() {

        Timber.plant(Timber.DebugTree())

        val booksRequest = apiService.listBooks()

        booksRequest.enqueue(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                val allBooks = response.body()
                if (allBooks != null) {
                    bookList = allBooks.map { b  -> b.isbn!! to b }.toMap()
                }
                initTotal()
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                Timber.e(t)
            }
        })
    }

    override fun getCart(): Map<Book?, Int> {
       return model.getCart().map { (isbn, amount) -> bookList?.get(isbn) to amount}.toMap()
    }

    private fun initTotal() {
        val cart = model.getCart()
        val booksRequest = apiService.getDiscounts(isbns =  cart.keys.joinToString(","))

        for ((isbn, amount) in model.getCart()) {
            total += (bookList?.get(isbn)?.price?.toInt() ?: 0)*amount
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

    override fun removeBook(book: Book,context: Context) {
        model.removeBook(book.isbn!!)
        view.updateViewData()
    }

    override fun addBook(book: Book, context: Context) {
        model.addBook(book.isbn!!)
        cartService.addBook(context, book)
        view.updateViewData()
    }

    override fun getTotal(): Pair<Double, Offer?> {
        return Pair(total, discount)
    }


    override fun flushCart(context: Context) {
        cartService.retrieveCart(context)
        model.setCart(HashMap())
    }


}