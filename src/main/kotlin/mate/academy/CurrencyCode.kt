package mate.academy

const val REQUIRED_CODE_LENGTH = 3

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.length == REQUIRED_CODE_LENGTH && code.all { it.isUpperCase() })
    }
}
