package mate.academy

private const val REQUIRED_LENGTH = 10

@JvmInline
value class AccountNumber(val accountNumber: String) {
    init {
        require(accountNumber.length == REQUIRED_LENGTH && accountNumber.all { c: Char -> c.isDigit() })
    }
}