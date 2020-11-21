package com.example.henripotier.model

import com.example.henripotier.contract.CartContractInterface.Model


class Cart: Model {
    private var cart: HashMap<String, Int> = hashMapOf()

    override fun getCart(): HashMap<String, Int> {
        return cart
    }

    override fun removeBook(book: String) {
        if (cart.containsKey(book)) {
            cart[book] = cart[book]!!.minus(1)
            if (cart[book]!! <= 0) {
                cart.remove(book)
            }
        }
    }

    override fun addBook(book: String) {
        if (cart.containsKey(book)) {
            cart[book] = cart[book]!!.plus(1)
        }
    }

    override fun setCart(cart:HashMap<String, Int>){
        this.cart = cart
    }

}