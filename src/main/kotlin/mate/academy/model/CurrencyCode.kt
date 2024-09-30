package mate.academy.model

import java.lang.IllegalArgumentException

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        if (code.uppercase() != code || code.length < 3) {
            throw IllegalArgumentException("Code is invalid!")
        }
    }
}
