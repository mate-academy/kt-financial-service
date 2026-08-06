package mate.academy.model

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.matches(Regex("^[A-Z]{3}$"))) { "Invalid currency code format" }
    }
}
