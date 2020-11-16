package com.example.henripotier.presenter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.app.ActivityCompat.startActivity
import androidx.core.app.ActivityCompat.startActivityForResult
import com.example.henripotier.R
import com.example.henripotier.model.Book
import com.example.henripotier.view.BookDetailsActivity
import com.example.henripotier.view.BookItemView

class BookItemAdapter(context: Context, private val books: List<Book>) : BaseAdapter() {

    private var inflater = LayoutInflater.from(context)
    private var context = context

    override fun getCount(): Int {
        return books.size
    }

    override fun getItem(position: Int): Book {
        return books[position]
    }

    override fun getItemId(position: Int): Long {

        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {

        val view = convertView ?: inflater.inflate(R.layout.custom_view_item_book, parent, false)
        val book = getItem(position)

        val intent = Intent(context, BookDetailsActivity::class.java)
        intent.putExtra("BOOK", books[position])

        view.setOnClickListener {
            startActivity(context, intent, Bundle.EMPTY)
        }

        (view as BookItemView).bindView(book)

        return view
    }

}