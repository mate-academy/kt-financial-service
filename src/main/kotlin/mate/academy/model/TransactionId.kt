package mate.academy.model

@JvmInline
value class TransactionId(val transactionId: String) {
    init {
        require(transactionId.isNotEmpty())
    }
}
