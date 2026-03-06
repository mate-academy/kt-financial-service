package mate.academy.value

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= 0) {
            "Currency amount cannot be negative"
        }
    }
}
