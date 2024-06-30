package mate.academy

@JvmInline
value class AccountNumber(val accountNumber: String) {
    init {
        require(
            accountNumber.matches(Regex("\\d{10}"))
        ) { "Account number must be a 10-digit string" }
    }
}
