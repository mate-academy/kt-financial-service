package mate.academy.model

@JvmInline
value class AccountNumber(val id: String) {
    init {
        require(id.matches(Regex("^[0-9]{10}$"))) { "Invalid account number format" }
    }
}
