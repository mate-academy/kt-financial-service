package mate.academy

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= 0) { "Amount must be greater than 0" }
    }

    override fun toString(): String {
        return amount.toString()
    }
}
