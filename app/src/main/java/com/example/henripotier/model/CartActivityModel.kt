package com.example.henripotier.model

import com.example.henripotier.contract.CartContractInterface.Model


class CartActivityModel : Model {

    private var cart: HashMap<Book, Int> = hashMapOf(
        Book("1", "title", "1", "ok", emptyList()) to 1,
        Book("2", "title is musch longer and might need two line", "1", "ok", emptyList()) to 4,
        Book("5", "title is musch longer and might need two line", "1", "ok", emptyList()) to 4,
        Book("3", "title is musch longer and might need two line", "1", "ok", emptyList()) to 4,
        Book("4", "title is musch longer and might need two line", "1", "ok", emptyList()) to 4
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