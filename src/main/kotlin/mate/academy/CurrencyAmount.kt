package mate.academy

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= 0) {
            "Monetary amount should be non-negative. Provided: $amount"
        }
    }
}
