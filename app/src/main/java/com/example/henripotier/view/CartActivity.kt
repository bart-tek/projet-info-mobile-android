package com.example.henripotier.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
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
        presenter = CartActivityPresenter(this)
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
        val linearLayout = findViewById<LinearLayout>(R.id.cartItemListView)

        val items = presenter.getCart()
        val inflater = LayoutInflater.from(this)
        if (items.isNotEmpty()) {
            for (item in items) {
                var view = inflater.inflate(R.layout.custom_view_item_cart, linearLayout, false)

                (view as CartItemView).bindView(item.key, item.value)
                linearLayout.addView(view)
            }

        } else {
            val emptyText = inflater.inflate(R.layout.empty_cart_view, linearLayout, false)
            linearLayout.addView(emptyText)
        }
        val totalTextView = findViewById<TextView>(R.id.total)
        totalTextView.text =
            String.format(resources.getString(R.string.bookPrice), presenter.getTotal())

        if (presenter.getCart().isNotEmpty()) {
            val buyButton = findViewById<Button>(R.id.buyButton)
            buyButton.isEnabled = true
        }
    }
}
