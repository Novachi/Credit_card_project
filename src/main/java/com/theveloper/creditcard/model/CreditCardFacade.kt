package com.theveloper.creditcard.model

import java.math.BigDecimal

class CreditCardFacade (val ccStorage: InMemoryCCStorage) {
    fun withdrawFromCard(creditCardNumber: String, withdrawValue: BigDecimal) {
        card: CreditCard = ccStorage.load(creditCardNumber)
        card.withdraw(withdrawValue)
        ccStorage.add(card)
    }
}
