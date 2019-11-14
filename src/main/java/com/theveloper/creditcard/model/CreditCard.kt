package com.theveloper.creditcard.model

import com.theveloper.creditcard.exception.CreditBelowMinimumException
import com.theveloper.creditcard.exception.NotEnoughMoneyException
import java.math.BigDecimal

internal class CreditCard(private val cardNumber: String) {
    var limit: BigDecimal? = null
        private set
    private val slogan: String? = null
    private var cardBalance: BigDecimal? = null

    fun assignLimit(newLimit: BigDecimal) {
        if (BigDecimal.valueOf(100).compareTo(newLimit) == 1) {
            throw CreditBelowMinimumException("Unlucky sytuacja ")
        }

        limit = newLimit
        cardBalance = limit
    }

    fun withdraw(money: BigDecimal) {
        if (currentBalance()!!.compareTo(money) == -1) {
            throw NotEnoughMoneyException()
        }

        cardBalance = cardBalance!!.subtract(money)
    }

    fun currentBalance(): BigDecimal? {
        return cardBalance
    }
}
