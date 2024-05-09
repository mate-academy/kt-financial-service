package mate.academy

private const val CODE_LENGTH = 3

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.length == CODE_LENGTH && code.all { c: Char -> c.isLetter() && c.isUpperCase() })
    }
}
