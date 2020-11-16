package com.example.henripotier.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.henripotier.R
import com.example.henripotier.contract.CartContractInterface
import com.example.henripotier.presenter.CartActivityPresenter
import com.example.henripotier.presenter.CartAdapter


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
        return when (item.getItemId()) {
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
        val listView = findViewById<ListView>(R.id.cartItemListView)
        listView.adapter = CartAdapter(this, presenter.getCart())

        val emptyText = findViewById<View>(R.id.emptyCartView) as TextView
        listView.emptyView = emptyText

        val totalTextView =findViewById<TextView>(R.id.total)
        totalTextView.text = String.format(resources.getString(R.string.bookPrice), presenter.getTotal())
    }
}
