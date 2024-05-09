package mate.academy

private const val NUM_LENGTH = 10

@JvmInline
value class AccountNumber(val accountNumber: String) {
    init {
        require(accountNumber.length == NUM_LENGTH && accountNumber.all { c: Char -> c.isDigit() })
    }
}
