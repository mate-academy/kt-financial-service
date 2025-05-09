package mate.academy.model

private const val DEFAULT_LENGTH = 10

@JvmInline
value class AccountNumber(val accountNumber: String) {
    init {
        require(accountNumber.all { it.isDigit() })
        require(accountNumber.length == DEFAULT_LENGTH)
    }
}
