package mate.academy.model

const val ACCOUNT_LENGTH = 10

@JvmInline
value class AccountNumber(val number: String) {
    init {
        require(number.length == ACCOUNT_LENGTH && number.all { it.isDigit() }) {
            "Invalid account number format: $number"
        }
    }
}
