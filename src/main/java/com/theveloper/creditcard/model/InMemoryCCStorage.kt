package com.theveloper.creditcard.model

internal class InMemoryCCStorage(val storage: HashMap<String, CreditCard>) {
    fun add(card: CreditCard) {
        storage[card.cardNumber] = card
    }

    fun load(creditCardNumber: String): CreditCard? {
        return storage[creditCardNumber]
    }
}