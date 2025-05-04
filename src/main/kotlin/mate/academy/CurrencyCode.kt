package mate.academy

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.matches(Regex("^[A-Z]{3}$"))) {
            "Currency code should be a 3-letter uppercase format. Provided: $code"
        }
    }
}
