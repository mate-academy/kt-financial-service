package mate.academy

const val ZERO = 0.0

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= ZERO)
    }
}
