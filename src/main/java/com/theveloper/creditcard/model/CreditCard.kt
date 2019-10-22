package com.theveloper.creditcard.model

import com.theveloper.creditcard.exception.BelowMinimumValueException
import java.lang.Exception
import java.math.BigDecimal

class CreditCard(private var balance: BigDecimal, limit:BigDecimal) {
    var limit:BigDecimal = BigDecimal.ZERO
    private set(newLimit){
        if(newLimit >= BigDecimal(100)){
            field = newLimit
        } else {
            throw BelowMinimumValueException("Limit cannot be below 100")
        }
    }

    init {
        this.limit = limit
    }

    fun assignLimit(value: BigDecimal){
        this.limit = value
    }
}