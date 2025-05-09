package mate.academy.model

const val ACCOUNT_NUMBER_LENGTH = 10
const val INVALID_LENGTH_OR_NON_DIGIT = "Account number must be a string of $ACCOUNT_NUMBER_LENGTH digits."

@JvmInline
value class AccountNumber(val number: String) {
    init {
        require(number.length == ACCOUNT_NUMBER_LENGTH && number.all { it.isDigit() }) {
            INVALID_LENGTH_OR_NON_DIGIT
        }
    }
}
