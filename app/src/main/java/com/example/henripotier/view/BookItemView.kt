package com.example.henripotier.view

import android.content.Context
import android.provider.Settings.Global.getString
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.henripotier.R
import com.example.henripotier.model.Book
import com.squareup.picasso.Picasso


class BookItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
        LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var nameTextView : TextView
    private lateinit var priceTextView : TextView
    private lateinit var coverImgView : ImageView

    override fun onFinishInflate() {
        super.onFinishInflate()
        nameTextView = findViewById(R.id.nameTextView)
        priceTextView = findViewById(R.id.priceTextView)
        coverImgView = findViewById(R.id.coverImgView)
    }

    fun bindView(book: Book) {
        nameTextView.text = book.title
        priceTextView.text = String.format(resources.getString(R.string.bookPrice), book.price)
        Picasso.get().load(book.cover).into(coverImgView)
    }
}
