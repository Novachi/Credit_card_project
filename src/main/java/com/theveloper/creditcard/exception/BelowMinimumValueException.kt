package com.theveloper.creditcard.exception

import java.lang.IllegalStateException

class BelowMinimumValueException(errorText:String): IllegalStateException(errorText) {
}