package com.example.henripotier.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.henripotier.R
import com.example.henripotier.api.CartService
import com.example.henripotier.components.WrapContentViewPager
import com.example.henripotier.contract.BookDetailsContract
import com.example.henripotier.presenter.BookDetailsActivityPresenter
import com.example.henripotier.presenter.BookDetailsTabAdapter
import com.google.android.material.tabs.TabLayout
import com.squareup.picasso.Picasso


class BookDetailsFragment : Fragment(), BookDetailsContract.View {

    private lateinit var presenter: BookDetailsActivityPresenter
    private val cartService = CartService()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return if (arguments != null) {
            inflater.inflate(R.layout.book_details_fragment, container, false)
        } else {
            inflater.inflate(R.layout.fragment_blank, container, false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            presenter = BookDetailsActivityPresenter(this, arguments)
            initView()
        }
    }

    override fun initView() {
        val cover = view?.findViewById<ImageView>(R.id.coverDetails)
        Picasso.get().load(presenter.getCover()).into(cover)

        val title = view?.findViewById<TextView>(R.id.titreDetails)
        title?.text = presenter.getTitle()

        val fragmentAdapter =
            activity?.supportFragmentManager?.let { BookDetailsTabAdapter(it, presenter) }
        val viewPager = view?.findViewById<WrapContentViewPager>(R.id.viewpager_main)
        val tabLayout = view?.findViewById<TabLayout>(R.id.tabs_main)
        viewPager?.adapter = fragmentAdapter
        tabLayout?.setupWithViewPager(viewPager);

        val addToCartButton = view?.findViewById<Button>(R.id.add_to_cart)
        addToCartButton?.setOnClickListener {
            activity?.baseContext?.let { it1 -> cartService.addBook(it1, presenter.getBook()) }
        }
    }

    override fun updateViewData() {
    }
}