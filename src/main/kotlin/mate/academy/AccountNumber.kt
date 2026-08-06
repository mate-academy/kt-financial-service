package mate.academy

@JvmInline
value class AccountNumber(val accountNumber: String) {
    init {
        require(accountNumber.matches(Regex("\\d{10}"))) { "Account number should be 10 digit string" }
    }

    override fun toString(): String {
        return accountNumber
    }
}
