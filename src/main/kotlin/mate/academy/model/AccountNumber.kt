package mate.academy.model

const val SOURCE_LENGTH = 10

@JvmInline
value class AccountNumber(val source: String) {
    init {
        when {
            source.length != SOURCE_LENGTH ->
                throw IllegalArgumentException("Source must be exactly 10 characters long")
            source.any { !it.isDigit() } ->
                throw IllegalArgumentException("Source must contain only digits")
        }
    }
}
