package mate.academy

@JvmInline
value class TransactionId(val transactionId: String) {
    init {
        require(transactionId.isNotEmpty()) { "Transaction ID must not be empty" }
    }
}
