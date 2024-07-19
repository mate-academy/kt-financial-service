package mate.academy

private const val CODE_LENGTH = 3

@JvmInline
value class CurrencyCode(val code: String) {

    init {
        require(code.length == CODE_LENGTH && code.all { it.isUpperCase() }) {
            "code must be a 3-char uppercase string"
        }
    }

}
