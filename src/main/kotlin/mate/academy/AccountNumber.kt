package mate.academy

@JvmInline
value class AccountNumber(val number: String) {
    init {
        require(isValidAccountNumber(number)) {
            "The account number should consist of exactly 10 digits " +
                    "and contain only numeric characters."
        }
    }

    companion object {
        private const val REQUIRED_LENGTH = 10

        fun isValidAccountNumber(number: String): Boolean {
            return number.length == REQUIRED_LENGTH && number.all { it.isDigit() }
        }
    }
}