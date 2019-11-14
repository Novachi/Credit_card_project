package com.theveloper.creditcard.exception

import java.lang.IllegalStateException

class CreditBelowMinimumException(errorText:String): IllegalStateException(errorText) {
}