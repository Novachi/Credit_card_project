package com.theveloper.creditcard.model

import com.theveloper.creditcard.exception.CreditBelowMinimumException
import com.theveloper.creditcard.exception.NotEnoughMoneyException
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.math.BigDecimal

class CreditCardTest {

    @Test
    fun itAllowAssignLimitToCreditCard() {
        //Arrange // Given
        val creditCard = CreditCard("1234-5678")
        //Act // When
        creditCard.assignLimit(BigDecimal.valueOf(NEW_CREDIT_LIMIT.toLong()))
        //Assert // Then // Expect
        Assert.assertTrue(creditCard.getLimit().equals(BigDecimal.valueOf(NEW_CREDIT_LIMIT.toLong())))
    }

    @Test
    fun itVerifyMinimumCreditValue() {

        val card = CreditCard("1234-5678")

        try {
            card.assignLimit(BigDecimal.valueOf(50))
            Assert.fail("Exception should be thrown")
        } catch (e: CreditBelowMinimumException) {
            Assert.assertTrue(true)
        }

    }

    @Test
    fun foo() {
        val card = CreditCard("1234-5678")
        card.assignLimit(BigDecimal.valueOf(100))
        Assert.assertTrue(card.getLimit().equals(BigDecimal.valueOf(100)))
    }

    @Test
    fun withdrawFromCard() {
        val card1 = CreditCard("1234-5678")
        val card2 = CreditCard("1234-5678")
        card1.assignLimit(BigDecimal.valueOf(1000))
        card2.assignLimit(BigDecimal.valueOf(1000))
        card1.withdraw(BigDecimal.valueOf(500))
        card2.withdraw(BigDecimal.valueOf(200))
        Assert.assertEquals(card1.currentBalance(), BigDecimal.valueOf(500))
        Assert.assertEquals(card2.currentBalance(), BigDecimal.valueOf(800))
    }

    @Test(expected = NotEnoughMoneyException::class)
    fun denyWithdrawBelowCurrentBalance() {
        val card = CreditCard("1234-5678")
        card.assignLimit(BigDecimal.valueOf(1000))

        card.withdraw(BigDecimal.valueOf(600))
        card.withdraw(BigDecimal.valueOf(600))
    }

    companion object {

        val NEW_CREDIT_LIMIT = 2000
    }

}