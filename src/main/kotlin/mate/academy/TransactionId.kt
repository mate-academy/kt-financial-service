package mate.academy

@JvmInline
value class TransactionId(val id: String) {
    init {
        require(id.isNotBlank()) { "Transaction ID cannot be empty" }
    }
}
