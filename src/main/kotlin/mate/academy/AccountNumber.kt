package mate.academy

private const val NEED_LENGTH = 10

@JvmInline
value class AccountNumber(val accountNumber: String) {
    init {
        require(accountNumber.length == NEED_LENGTH && accountNumber.all { c: Char -> c.isDigit() })
    }
}
