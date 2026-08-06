package mate.academy.model

const val MINIMUM_AMOUNT = 0.0
const val NEGATIVE_AMOUNT = "Amount must be non-negative."

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= MINIMUM_AMOUNT) { NEGATIVE_AMOUNT }
    }
}
