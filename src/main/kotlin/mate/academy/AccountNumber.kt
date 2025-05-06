package mate.academy

@JvmInline
value class AccountNumber(val number: String) {
    init {
        require(number.matches(Regex("^\\d{10}$"))) { "Account number must be exactly 10 digits." }
    }
}
