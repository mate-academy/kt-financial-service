package mate.academy.model

@JvmInline
value class AccountNumber(val number: String) {
    init {
        require(number.matches(Regex("\\d{10}")))
        { "Account number must be a 10-digit string" }
    }
}
