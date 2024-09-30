package mate.academy.model

import java.lang.IllegalArgumentException

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= 0) { "Amount must be more or equals to 0." }
    }
}
