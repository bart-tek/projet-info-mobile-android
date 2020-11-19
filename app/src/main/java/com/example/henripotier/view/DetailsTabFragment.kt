package com.example.henripotier.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.henripotier.R
import com.example.henripotier.presenter.BookDetailsActivityPresenter

class DetailsTabFragment(private val presenter: BookDetailsActivityPresenter) : Fragment() {

    private var priceTextView: TextView? = null
    private var isbnTextView: TextView? = null

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.details_tab_fragment, container, false)

        priceTextView = view.findViewById(R.id.priceDetails)
        priceTextView?.text = String.format(resources.getString(R.string.bookPrice), presenter.getPrice())

        isbnTextView = view.findViewById(R.id.isbnDetails)
        isbnTextView?.text = presenter.getIsbn()

        return view
    }
}