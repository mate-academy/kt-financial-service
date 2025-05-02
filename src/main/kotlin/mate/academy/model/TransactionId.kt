package mate.academy.model

@JvmInline
value class TransactionId(val id: String) {
    init {
        require(id.isNotEmpty()) { "Transaction ID must not be empty." }
    }
}
