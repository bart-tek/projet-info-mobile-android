package com.example.henripotier.model

import com.example.henripotier.contract.CartContractInterface.Model


class CartActivityModel : Model {

    private var cart: HashMap<Book, Int> = hashMapOf(
        Book(
            "c8fabf68-8374-48fe-a7ea-a00ccd07afff",
            "Henri Potier à l'école des sorciers",
            "35",
            "ok",
            ArrayList()
        ) to 1,
        Book(
            "a460afed-e5e7-4e39-a39d-c885c05db861",
            "Henri Potier à l'école des sorciers",
            "30",
            "ok",
            ArrayList()
        ) to 1,
        Book(
            "fcd1e6fa-a63f-4f75-9da4-b560020b6acc",
            "Henri Potier à l'école des sorciers",
            "30",
            "ok",
            ArrayList()
        ) to 1
    )

    override fun getCart(): HashMap<Book, Int> {
        return cart
    }

    override fun removeBook(book: Book) {
        if (cart.containsKey(book)) {
            cart[book] = cart[book]!!.minus(1)
            if (cart[book]!! <= 0) {
                cart.remove(book)
            }
        }
    }

    override fun addBook(book: Book) {
        if (cart.containsKey(book)) {
            cart[book] = cart[book]!!.plus(1)
        }
    }

    override fun flushCart() {
        TODO("Not yet implemented")
    }


}