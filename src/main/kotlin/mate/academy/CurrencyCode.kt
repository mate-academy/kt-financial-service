package mate.academy

const val CODE_LENGTH = 3

@JvmInline
value class CurrencyCode(val code: String) {
    init {
        require(code.length == CODE_LENGTH) { "Currency code must be exactly 3 characters long" }
        require(code.all { it.isUpperCase() }) { "Currency code must contain only uppercase letters" }
    }

    override fun toString(): String {
        return code.toString()
    }
}
