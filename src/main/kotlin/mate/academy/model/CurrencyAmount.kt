package mate.academy.model

@JvmInline
value class CurrencyAmount(val amount: Double) {
    init {
        require(amount >= 0.0) {"The amount shouldn`t be negative."}
    }
}
