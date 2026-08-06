package mate.academy

private const val NEED_LENGTH = 3

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.length == NEED_LENGTH && code.all { c: Char -> c.isLetter() && c.isUpperCase() })
    }
}
