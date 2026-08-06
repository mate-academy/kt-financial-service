package mate.academy.models

import org.jetbrains.annotations.NotNull

@JvmInline
value class CurrencyAmount(@NotNull val amount: Double) {
    init {
        require(amount >= 0) {
            throw IllegalArgumentException("Illegal argument")
        }
    }
}
