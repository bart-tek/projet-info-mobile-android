package com.example.henripotier.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Offer(
    val type: String,
    val value: Int,
    val sliceValue: Int
) : Parcelable {

    fun calculateDiscount(total: Double): Double {
        return when (type) {
            "percentage" -> total * ((100.0 - value.toDouble()) / 100.0)
            "minus" -> total - value
            "slice" -> total - (total / sliceValue).toInt() * value
            else -> total
        }
    }

    override fun toString(): String {
        return when (type) {
            "percentage" -> "$value% reduction"
            "minus" -> "Reduction of $value€"
            "slice" -> "Pay $value€ less every $sliceValue€"
            else -> "No discount"
        }
    }

    companion object {
        fun bestOffer(offers: List<Offer>?, total: Double): Offer? {
            if (offers != null) {
                return offers.minByOrNull { offer -> offer.calculateDiscount(total = total) }
            } else {
                return Offer("minus", 0, 0)
            }

        }
    }
}
