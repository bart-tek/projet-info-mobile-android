package com.example.henripotier.view

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.henripotier.R
import com.example.henripotier.contract.LibraryContractInterface
import com.example.henripotier.presenter.BookItemAdapter
import com.example.henripotier.presenter.LibraryActivityPresenter


class LibraryFragment() : Fragment(), LibraryContractInterface.View {

    private lateinit var presenter: LibraryActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        return inflater.inflate(R.layout.library_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = LibraryActivityPresenter(this)
    }

    override fun initView() {
        val listView = view?.findViewById<ListView>(R.id.bookListView)

        listView?.adapter = context?.let { BookItemAdapter(it, presenter.getBookList(), activity as AppCompatActivity) }
    }

    override fun updateViewData() {
        val listView = view?.findViewById<ListView>(R.id.bookListView)
        listView?.adapter = context?.let { BookItemAdapter(it, presenter.getBookList(), activity as AppCompatActivity) }
    }
}
