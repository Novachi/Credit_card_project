package com.theveloper.creditcard.model

import java.math.BigDecimal

class CreditCard(private var balance: BigDecimal, limit:BigDecimal) {
    var limit:BigDecimal = BigDecimal.ZERO
    private set(newLimit){
        if(newLimit >= BigDecimal(100)){
            field = newLimit
        }
        field = newLimit
    }

    init {
        this.limit = limit
    }

    fun assignLimit(value: BigDecimal){
        this.limit = value
    }
}