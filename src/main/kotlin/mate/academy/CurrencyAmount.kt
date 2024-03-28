package mate.academy

private const val MINIMAL = 0.0

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= MINIMAL)
    }
}
