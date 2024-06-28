package mate.academy

@JvmInline
value class AccountNumber(val number: String) {
    init {
        require(number.matches(Regex("\\d{10}"))) {
            "Account number should have 10 digits. Provided: $number"
        }
    }
}
