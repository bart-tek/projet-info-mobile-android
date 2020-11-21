package com.example.henripotier.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable
import java.util.ArrayList

@Serializable
@Parcelize
data class Book(
    val isbn: String?,
    val title: String?,
    val price: String?,
    val cover: String?,
    val synopsis: ArrayList<String>?
) : Parcelable {


}
