package mate.academy

@JvmInline
value class AccountNumber (val code: String) {
    init {
        require(code.matches(Regex("^[0-9]{10}$"))) { "Account code must be 10 digits" }
    }
}
