package mate.academy.model

@JvmInline
value class AccountNumber(val accountNumber: String) {
    init {
        if (!accountNumber.all { it.isDigit() } || accountNumber.length != 10) {
            throw IllegalArgumentException("Account number is invalid!")
        }
    }
}