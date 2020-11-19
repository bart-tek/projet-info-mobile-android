package com.example.henripotier.model

import com.example.henripotier.contract.CartContractInterface.Model


class Cart: Model {
    private var cart: HashMap<Book, Int> = hashMapOf()

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

    override fun setCart(cart:HashMap<Book, Int>){
        this.cart = cart
    }

}