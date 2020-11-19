package com.example.henripotier.presenter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.startActivity
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.example.henripotier.R
import com.example.henripotier.model.Book
import com.example.henripotier.view.BookDetailsFragment
import com.example.henripotier.view.BookItemView
import com.example.henripotier.view.LibraryFragment

class BookItemAdapter(context: Context, private val books: List<Book>, private var activity: AppCompatActivity) : BaseAdapter() {

    private var inflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return books.size
    }

    override fun getItem(position: Int): Book {
        return books[position]
    }

    override fun getItemId(position: Int): Long {

        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {

        val view = convertView ?: inflater.inflate(R.layout.custom_view_item_book, parent, false)
        val book = getItem(position)

        var bundle = Bundle()
        bundle.putParcelable("BOOK", books[position])

        view.setOnClickListener {

            val detailsFragment = BookDetailsFragment()
            detailsFragment.arguments = bundle

            if (activity.findViewById<FrameLayout>(R.id.details_fragment) != null) {
                (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
                activity.supportFragmentManager
                          .beginTransaction()
                          .replace(R.id.details_fragment, detailsFragment, "detail")
                          .addToBackStack(LibraryFragment::class.java.name)
                          .commit()
            }
            else {
                (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
                activity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, detailsFragment, "detail")
                    .addToBackStack(LibraryFragment::class.java.name)
                    .commit()
            }
        }

        (view as BookItemView).bindView(book)

        return view
    }

}