package com.theveloper.creditcard.model

import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class CreditCardApiTest {
    private var inMemoryCCStorage: InMemoryCCStorage? = null
    private var api: CreditCardFacade? = null

    @Test
    fun withdrawFromCard() {
        thereIsCCStorage()
        thereIsCreditCard()
        thereIsCCApi()

        api!!.withdrawFromCard(CREDIT_CARD_NUMBER, WITHDRAW_VALUE)

        currentBalanceForCCEquals(CREDIT_CARD_NUMBER, BigDecimal.valueOf(500))
    }

    private fun currentBalanceForCCEquals(creditCardNumber: String, expectedBallance: BigDecimal) {
        val loaded = inMemoryCCStorage!!.load(creditCardNumber)

        Assert.assertEquals(expectedBallance, loaded.currentBalance())
    }

    private fun thereIsCCApi() {
        api = CreditCardFacade(inMemoryCCStorage)
    }

    private fun thereIsCreditCard() {
        val card = CreditCard(CREDIT_CARD_NUMBER)
        card.assignLimit(BigDecimal.valueOf(INITIAL_LIMIT.toLong()))

        inMemoryCCStorage!!.add(card)
    }

    private fun thereIsCCStorage() {
        inMemoryCCStorage = InMemoryCCStorage()
    }

    companion object {

        val WITHDRAW_VALUE = BigDecimal.valueOf(500)
        val CREDIT_CARD_NUMBER = "1234-5678"
        val INITIAL_LIMIT = 1000
    }
}