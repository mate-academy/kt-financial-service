package mate.academy.value

@JvmInline
value class AccountNumber(val accountNumber: String) {
    init {
        require(accountNumber.matches(Regex("^\\d{10}$"))) {
            "Account number must be 10 units length"
        }
    }
}
