package com.example.henripotier.presenter

import com.example.henripotier.api.RetrofitBuilder.apiService
import com.example.henripotier.contract.LibraryContractInterface.*
import com.example.henripotier.model.Book
import com.example.henripotier.model.LibraryActivityModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class LibraryActivityPresenter(_view: View): Presenter {

    private var view: View = _view
    private var model: Model = LibraryActivityModel()

    init {
        initBookList()
    }

    private fun initBookList() {

        Timber.plant(Timber.DebugTree())

        val booksRequest = apiService.listBooks()

        booksRequest.enqueue(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                val allBooks = response.body()
                if (allBooks != null) {
                    model.setBookList(allBooks)
                }
                view.updateViewData()
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                Timber.e(t)
            }
        })
    }

    override fun getBookList() = model.getBookList()

}