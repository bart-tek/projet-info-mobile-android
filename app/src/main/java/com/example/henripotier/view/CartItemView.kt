package com.example.henripotier.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import com.example.henripotier.R
import com.example.henripotier.model.Book


class CartItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
        LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var nameTextView : TextView
    private lateinit var totalTextView : TextView
    private lateinit var quantityTextView : TextView
    private lateinit var priceTextView : TextView

    override fun onFinishInflate() {
        super.onFinishInflate()
        nameTextView = findViewById(R.id.itemName)
        totalTextView = findViewById(R.id.itemTotal)
        quantityTextView = findViewById(R.id.itemQuantity)
        priceTextView = findViewById(R.id.itemPrice)
    }

    fun bindView(book: Book, amount:Int) {
        nameTextView.text = book.title

        quantityTextView.text = String.format(resources.getString(R.string.cartItemQuantity),  book.price)
        priceTextView.text = String.format(resources.getString(R.string.cartItemPrice),  book.price)
        totalTextView.text = String.format(resources.getString(R.string.cartItemTotal),  book.price!!.toInt()*amount)

    }
}
