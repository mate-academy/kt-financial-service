package mate.academy.value

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.matches(Regex("^[A-Z]{3}$"))) {
            "Currency code must be of the following format, for example: USD, EUR"
        }
    }
}
