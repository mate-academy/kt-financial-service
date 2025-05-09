package mate.academy

private const val MIN = 0.0

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= MIN)
    }
}
