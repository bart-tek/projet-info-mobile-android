package com.example.henripotier.model

import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

data class Book(
    val isbn: String?,
    val title: String?,
    val price: String?,
    val cover: String?,
    val synopsis: ArrayList<String>?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        isbn = parcel.readString(),
        title = parcel.readString(),
        price = parcel.readString(),
        cover = parcel.readString(),
        synopsis = parcel.createStringArrayList()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(isbn)
        parcel.writeString(title)
        parcel.writeString(price)
        parcel.writeString(cover)
        parcel.writeStringList(synopsis)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }

        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }

}
