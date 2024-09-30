package mate.academy.model

import java.lang.IllegalArgumentException

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.length >= 3) { "Currency code must be at least 3 characters long." }
        require(code.all { it.isUpperCase() }) { "Currency code must be in uppercase." }
    }
}
