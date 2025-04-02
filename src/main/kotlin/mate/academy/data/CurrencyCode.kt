package mate.academy.data

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.matches(Regex("[A-Z]{3}"))) {
            "The code should be a 3-letter uppercase format"
        }
    }
}
