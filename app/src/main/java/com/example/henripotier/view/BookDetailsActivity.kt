package com.example.henripotier.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.henripotier.R
import com.example.henripotier.contract.BookDetailsContract
import com.example.henripotier.model.Book
import com.example.henripotier.presenter.BookDetailsActivityPresenter
import com.example.henripotier.presenter.LibraryActivityPresenter
import com.squareup.picasso.Picasso

class BookDetailsActivity : AppCompatActivity(), BookDetailsContract.View {

    private lateinit var presenter: BookDetailsActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        presenter = BookDetailsActivityPresenter(this, intent)

        initView()
    }

    override fun initView() {
        val cover = findViewById<ImageView>(R.id.coverDetails)
        Picasso.get().load(presenter.getCover()).into(cover)

        val title = findViewById<TextView>(R.id.titreDetails)
        title.text = presenter.getTitle()

        val price = findViewById<TextView>(R.id.priceDetails)
        price.text = String.format(resources.getString(R.string.bookPrice), presenter.getPrice())
    }

    override fun updateViewData() {
    }

}