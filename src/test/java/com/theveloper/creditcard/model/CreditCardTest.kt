package com.theveloper.creditcard.model

import com.theveloper.creditcard.exception.BelowMinimumValueException
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.math.BigDecimal

class CreditCardTest {
    private lateinit var card: CreditCard
    @Before
    fun initializeCard(){
        card = CreditCard(BigDecimal.valueOf(230), BigDecimal.valueOf(100))
    }

    @Test
    fun itAllowsAssigningLimitToCreditCard(){
//        Act (when)
        card.assignLimit(BigDecimal.valueOf(2000))
//        Assert (then / expect)
        Assert.assertTrue(card.limit == BigDecimal.valueOf(2000))
    }

    @Test
    fun itVerifiesMinimumCreditValue(){
        try {
            card.assignLimit(BigDecimal.valueOf(10))
            Assert.fail("Exception should be thrown")
        } catch (e: BelowMinimumValueException){
            Assert.assertTrue(true)
        }
    }
}