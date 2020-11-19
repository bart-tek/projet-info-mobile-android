package com.example.henripotier.view

import android.content.Intent
import com.example.henripotier.components.WrapContentViewPager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.henripotier.R
import com.example.henripotier.contract.BookDetailsContract
import com.example.henripotier.presenter.BookDetailsActivityPresenter
import com.example.henripotier.presenter.BookDetailsTabAdapter
import com.squareup.picasso.Picasso


class BookDetailsActivity : AppCompatActivity(), BookDetailsContract.View {

    private lateinit var presenter: BookDetailsActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        presenter = BookDetailsActivityPresenter(this, intent)

        initView()
    }

    override fun initView() {
        val cover = findViewById<ImageView>(R.id.coverDetails)
        Picasso.get().load(presenter.getCover()).into(cover)

        val title = findViewById<TextView>(R.id.titreDetails)
        title.text = presenter.getTitle()

        val fragmentAdapter = BookDetailsTabAdapter(supportFragmentManager, presenter)
        val viewpagerMain = findViewById<WrapContentViewPager>(R.id.viewpager_main)
        viewpagerMain.adapter = fragmentAdapter
    }

    override fun updateViewData() {
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_details, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_cart_from_details) {
            val intent = Intent(this@BookDetailsActivity, CartActivity::class.java)
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}