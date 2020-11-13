package com.example.henripotier.view

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.henripotier.R
import com.example.henripotier.contract.LibraryContractInterface
import com.example.henripotier.presenter.BookAdapter
import com.example.henripotier.presenter.LibraryActivityPresenter

class LibraryActivity : AppCompatActivity(), LibraryContractInterface.View {

    private lateinit var presenter: LibraryActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        presenter = LibraryActivityPresenter(this)
    }

    override fun initView() {

    }

    override fun updateViewData() {

        val listView = findViewById<ListView>(R.id.bookListView)
        listView.adapter = BookAdapter(this, presenter.getBookList())

    }
}