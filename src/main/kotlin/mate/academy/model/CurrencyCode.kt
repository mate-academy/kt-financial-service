package mate.academy.model

@JvmInline
value class CurrencyCode(val code: String) {

    init {
        require(code.matches(Regex("[A-Z]{3}"))) { "Currency code must be a 3-letter uppercase string" }
    }

}
