package mate.academy

const val NECESSARY_LENGTH_CODE: Int = 3

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.length == NECESSARY_LENGTH_CODE && code == code.uppercase())
    }
}
