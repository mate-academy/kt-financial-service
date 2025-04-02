package mate.academy.data

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount > -1) { "Amount must be non negative number" }
    }
}