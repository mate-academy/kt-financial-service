package mate.academy.models

import org.jetbrains.annotations.NotNull

@JvmInline
value class CurrencyCode(@NotNull val code: String) {
    init {
        require(code.matches(Regex("^[A-Z]{3}$"))) {
            throw IllegalArgumentException("Illegal argument")
        }
    }
}
