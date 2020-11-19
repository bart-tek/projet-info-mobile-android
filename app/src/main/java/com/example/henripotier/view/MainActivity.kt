package com.example.henripotier.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.henripotier.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LibraryFragment(), "library")
                .commitNow()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_library, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_cart_from_library) {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
            return true
        }
        else if (item.itemId == android.R.id.home) {
            supportFragmentManager.popBackStack()
            return true
        }
        else {
            return super.onOptionsItemSelected(item)
        }
    }

}