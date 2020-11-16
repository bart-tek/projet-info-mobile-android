package com.example.henripotier.presenter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.henripotier.R
import com.example.henripotier.model.Book
import com.example.henripotier.view.BookItemView
import com.example.henripotier.view.CartItemView

class CartAdapter(context: Context, private val cart: HashMap<Book, Int>) : BaseAdapter() {

    private var inflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return cart.size
    }

    override fun getItem(position: Int): Pair<Book, Int> {
        return cart.toList()[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {

        val view = convertView ?: inflater.inflate(R.layout.custom_view_item_cart, parent, false)
        val item = getItem(position)

        (view as CartItemView).bindView(item.first, item.second)

        return view
    }

}