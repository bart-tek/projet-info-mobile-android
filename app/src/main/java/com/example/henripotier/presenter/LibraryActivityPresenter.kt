package com.example.henripotier.presenter

import com.example.henripotier.api.LibraryService
import com.example.henripotier.contract.LibraryContractInterface.*
import com.example.henripotier.model.BookModel
import com.example.henripotier.model.LibraryActivityModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import kotlin.math.log

class LibraryActivityPresenter(_view: View): Presenter {

    private var view: View = _view
    private var model: Model = LibraryActivityModel()

    init {
        view.initView()
        initBookList()
    }

    private fun initBookList() {

        Timber.plant(Timber.DebugTree())

        val retrofit = Retrofit.Builder().baseUrl("http://henri-potier.xebia.fr/").addConverterFactory(
            GsonConverterFactory.create()).build()

        val service = retrofit.create(LibraryService::class.java)

        var booksRequest = service.listBooks()

        booksRequest.enqueue(object : Callback<Array<BookModel>> {
            override fun onResponse(call: Call<Array<BookModel>>, response: Response<Array<BookModel>>) {
                val allBooks = response.body()
                if (allBooks != null) {
                    model.setBookList(allBooks.asList())
                }
                view.updateViewData()
            }

            override fun onFailure(call: Call<Array<BookModel>>, t: Throwable) {
                Timber.e("Error")
            }
        })
    }

    override fun getBookList() = model.getBookList()

}