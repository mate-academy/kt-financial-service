package mate.academy.model

@JvmInline
value class AccountNumber(val number: String) {
    init {
            require(number.matches(Regex("[0-9]{10}")))
    }
}
