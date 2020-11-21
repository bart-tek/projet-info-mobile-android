package com.example.henripotier.view

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.henripotier.R
import com.example.henripotier.contract.CartContractInterface
import com.example.henripotier.presenter.CartActivityPresenter


class CartActivity : AppCompatActivity(), CartContractInterface.View {

    private lateinit var presenter: CartActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        presenter = CartActivityPresenter(this, context = applicationContext)
        updateViewData()

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_cart, menu)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun initView() {
    }

    override fun updateViewData() {
        updateList()
        updateTotalSection()
    }

    private fun updateList() {
        val items = presenter.getCart()

        val linearLayout = findViewById<LinearLayout>(R.id.cartItemListView)
        // Make sure to remove previously added element
        linearLayout.removeAllViews()

        val inflater = LayoutInflater.from(this)
        if (items.isNotEmpty()) {
            // Add each element to linear layout
            for (item in items) {
                var view = inflater.inflate(R.layout.custom_view_item_cart, linearLayout, false)
                item.key?.let { (view as CartItemView).bindView(it, item.value) }
                linearLayout.addView(view)
            }
        } else {
            // In case to element were added to cart, display empty view
            val emptyText = inflater.inflate(R.layout.empty_cart_view, linearLayout, false)
            linearLayout.addView(emptyText)
        }

    }

    private fun updateTotalSection() {
        val totalAndDiscount = presenter.getTotal()

        val discountTextView = findViewById<TextView>(R.id.discount)
        val totalTextView = findViewById<TextView>(R.id.total)
        val toPayTextView = findViewById<TextView>(R.id.to_pay)

        val total = totalAndDiscount.first
        val toPay = totalAndDiscount.second?.calculateDiscount(total = total)

        discountTextView.text = totalAndDiscount.second.toString()
        totalTextView.text = String.format(resources.getString(R.string.bookPrice), total)
        toPayTextView.text = String.format(resources.getString(R.string.bookPrice), toPay)

        if (presenter.getCart().isNotEmpty()) {
            val buyButton = findViewById<Button>(R.id.buyButton)
            buyButton.isEnabled = true
        }
    }
}
