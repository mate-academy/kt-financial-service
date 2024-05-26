
package mate.academy

@JvmInline
value class CurrencyAmount (val amount: Double) {
    init {
        require(amount >= 0)
    }
}
