package mate.academy.model

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(Regex("^[A-Z]{3}$").matches(code)) {
            "The code should be a 3-letter uppercase format (e.g., USD, EUR)."
        }
    }
}
