package mate.academy

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.matches(Regex("[A-Z]{3}")))
    }

    override fun toString(): String {
        return code
    }
}
