package mate.academy.model

const val ZERO = 0

@JvmInline
value class CurrencyAmount(val amount: Double) {

    init {
        require(amount >= ZERO) { "Amount must be non-negative"}
    }

}
