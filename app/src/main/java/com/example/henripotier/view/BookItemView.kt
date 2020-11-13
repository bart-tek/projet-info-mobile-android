package com.example.henripotier.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import com.example.henripotier.R
import com.example.henripotier.model.BookModel

class BookItemView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var nameTextView : TextView
    private lateinit var priceTextView : TextView

    override fun onFinishInflate() {
        super.onFinishInflate()
        nameTextView = findViewById(R.id.nameTextView)
        priceTextView = findViewById(R.id.priceTextView)
    }

    fun bindView(book: BookModel) {
        nameTextView.text = book.title
        priceTextView.text = book.price.toString()
    }
}
