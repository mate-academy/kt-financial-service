package mate.academy

const val CODE_LENGTH = 3
@JvmInline
value class CurrencyCode (val code: String) {
    init {
        require(code.length == CODE_LENGTH)
        require(code == code.uppercase())
    }
}
