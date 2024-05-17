package mate.academy

@JvmInline
value class AccountNumber(val accountNumber: String) {
    init {
        require(accountNumber.matches(Regex("\\d{10}")))
    }

    override fun toString(): String {
        return accountNumber
    }
}
