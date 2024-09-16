package mate.academy.model

const val CURRENCY_CODE_LENGTH = 3
const val INVALID_CODE = "Currency code must be a three-letter string in uppercase."
val CURRENCY_CODE_REGEX = Regex("^[A-Z]{$CURRENCY_CODE_LENGTH}$")

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(CURRENCY_CODE_REGEX.matches(code)) {
            INVALID_CODE
        }
    }
}
