package mate.academy.models

@JvmInline
    value class CurrencyAmount(val amount: Double) {
        init {
            require(amount >= 0) { "amount should be greater than 0" }
        }
    }
