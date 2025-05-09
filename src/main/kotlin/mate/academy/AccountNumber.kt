package mate.academy

const val REQUIRED_ACC_LENGTH = 10

@JvmInline
value class AccountNumber(val accountNumber: String) {
    init {
        require(accountNumber.length == REQUIRED_ACC_LENGTH && accountNumber.all { it.isDigit() })
    }
}
