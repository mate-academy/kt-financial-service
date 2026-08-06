package mate.academy.model

@JvmInline
value class AccountNumber(val number: String) {
    init {
        require(Regex("""^\d{10}$""").matches(number)) {"The number should be a 10-digit string."}
    }
}
