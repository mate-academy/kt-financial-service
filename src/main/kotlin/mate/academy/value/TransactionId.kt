package mate.academy.value

@JvmInline
value class TransactionId(val transactionId: String) {
    init {
        require(transactionId.isNotBlank()) {
            "Transaction id is required"
        }
    }
}
