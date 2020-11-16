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


class CartItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
        LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var nameTextView : TextView
    private lateinit var priceTextView : TextView
    private lateinit var amountTextView : TextView

    override fun onFinishInflate() {
        super.onFinishInflate()
        nameTextView = findViewById(R.id.itemName)
        priceTextView = findViewById(R.id.itemTotal)
        amountTextView = findViewById(R.id.itemAmount)
    }

    fun bindView(book: Book, amount:Int) {
        nameTextView.text = book.title
        amountTextView.text = "$amount"
        priceTextView.text = String.format(resources.getString(R.string.bookPrice),  book.price.toInt()*amount)
    }
}
