package mate.academy.data

@JvmInline
value class AccountNumber(val accauntNumber: String) {
    init {
        require(accauntNumber.matches(Regex("\\d{10}"))) {
            "The number should be a 10-digit string"
        }
    }
}
