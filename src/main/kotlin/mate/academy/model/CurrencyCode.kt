package mate.academy.model

private const val DEFAULT_LENGTH = 3

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.length == DEFAULT_LENGTH) { "Currency code must be at least 3 characters long." }
        require(code.all { it.isUpperCase() }) { "Currency code must be in uppercase." }
    }
}
