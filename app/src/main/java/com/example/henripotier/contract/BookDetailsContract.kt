package com.example.henripotier.contract

import com.example.henripotier.model.Book
import java.util.ArrayList

interface BookDetailsContract {

    interface View {
        fun initView()
        fun updateViewData()
    }

    interface Presenter {
        fun getTitle() : String
        fun getPrice() : String
        fun getCover() : String
        fun getSynopsis() : String
        fun getIsbn() : String
    }

    interface Model {
        fun getTitle() : String
        fun getPrice() : String
        fun getCover() : String
        fun getSynopsis() : ArrayList<String>?
        fun getIsbn() : String
        fun setBook(book : Book)
    }

}