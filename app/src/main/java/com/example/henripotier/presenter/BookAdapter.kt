package com.example.henripotier.presenter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.henripotier.R
import com.example.henripotier.model.BookModel
import com.example.henripotier.view.BookItemView

class BookAdapter(context: Context, private val books: List<BookModel>) : BaseAdapter() {

    private var inflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return books.size
    }

    override fun getItem(position: Int): BookModel {
        return books[position]
    }

    override fun getItemId(position: Int): Long {

        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {

        val view = convertView ?: inflater.inflate(R.layout.custom_view_item_book, parent, false)
        val book = getItem(position)

        (view as BookItemView).bindView(book)

        return view
    }

}