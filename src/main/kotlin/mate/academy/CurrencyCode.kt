package mate.academy

@JvmInline
value class CurrencyCode(val code : String) {
    init {
        require(isValidCurrencyCode(code)) {"Currency code must be a 3-letter uppercase code"}
    }
    companion object{
        private const val REQUIRED_LENGTH = 3

        fun isValidCurrencyCode (code: String): Boolean {
           return code.length == REQUIRED_LENGTH && code.uppercase() == code
        }
    }
}