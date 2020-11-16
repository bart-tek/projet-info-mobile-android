package com.example.henripotier.model

import android.os.Parcel
import android.os.Parcelable

data class Book(
    val isbn: String?,
    val title: String?,
    val price: String?,
    val cover: String?,
    val synopsis: List<String>
) : Parcelable {

    constructor(parcel: Parcel) : this(
        isbn = parcel.readString(),
        title = parcel.readString(),
        price = parcel.readString(),
        cover = parcel.readString(),
        synopsis = emptyList()) {
        if (synopsis.isNotEmpty()) {
            parcel.readStringList(synopsis)
        }
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
