package mate.academy.model

import java.lang.IllegalArgumentException

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        if (amount < 0) {
            throw IllegalArgumentException("Monetary amount can't be negative!")
        }
    }
}