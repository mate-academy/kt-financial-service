package mate.academy.model

@JvmInline
value class TransactionId(val transactionId: String) {
    init {
        if (transactionId.isEmpty()) {
            throw IllegalArgumentException("Transaction id is invalid!")
        }
    }
}