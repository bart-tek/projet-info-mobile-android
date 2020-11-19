package com.example.henripotier.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.henripotier.R
import com.example.henripotier.presenter.BookDetailsActivityPresenter

class SynopsisTabFragment(private val presenter: BookDetailsActivityPresenter) : Fragment() {

    private var synopsisText: TextView? = null

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.synopsis_fragment, container, false)

        synopsisText = view.findViewById(R.id.synopsisText)
        synopsisText?.text = presenter.getSynopsis()

        return view
    }

}