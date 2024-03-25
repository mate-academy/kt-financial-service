package mate.academy

private const val REQUIRED_LENGTH = 3

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.length == REQUIRED_LENGTH && code.all { c: Char -> c.isLetter() && c.isUpperCase() })
    }
}