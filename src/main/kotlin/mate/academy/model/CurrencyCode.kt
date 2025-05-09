package mate.academy.model

const val CURRENCY_CODE_LENGTH = 3

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.length == CURRENCY_CODE_LENGTH && code.all { it.isUpperCase() }) {
            "Invalid currency code format: $code"
        }
    }
}
