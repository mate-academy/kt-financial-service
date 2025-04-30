package mate.academy.model

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= 0) { "Amount should be non-negative" }
    }
}
