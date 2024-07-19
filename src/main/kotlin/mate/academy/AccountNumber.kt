package mate.academy

private const val ACCOUNT_NUMBER_LENGTH = 10

@JvmInline
value class AccountNumber(val number: String) {

    init {
        require(number.length == ACCOUNT_NUMBER_LENGTH && number.all { it.isDigit() }) {
            "amount must be a 10-char string"
        }
    }

}
