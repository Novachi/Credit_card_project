package com.theveloper.creditcard.model

import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class CreditCardTest {
    @Test
    fun itAllowAssignLimitToCreditCard(){
//        Arrange (given)
        val card = CreditCard(BigDecimal.valueOf(230), BigDecimal.valueOf(100))
//        Act (when)
        card.assignLimit(BigDecimal.valueOf(2000))
//        Assert (then / expect)
        Assert.assertTrue(card.limit == BigDecimal.valueOf(2000))
    }
}