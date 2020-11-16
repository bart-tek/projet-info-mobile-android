package com.example.henripotier.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.henripotier.R
import com.example.henripotier.contract.LibraryContractInterface
import com.example.henripotier.presenter.BookItemAdapter
import com.example.henripotier.presenter.LibraryActivityPresenter


class LibraryActivity : AppCompatActivity(), LibraryContractInterface.View {

    private lateinit var presenter: LibraryActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        presenter = LibraryActivityPresenter(this)
    }

    override fun initView() {
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_favorite) {
            val intent = Intent(this@LibraryActivity, CartActivity::class.java)
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_library, menu)
        return true
    }

    override fun updateViewData() {

        val listView = findViewById<ListView>(R.id.bookListView)
        listView.adapter = BookItemAdapter(this, presenter.getBookList())

    }
}
