package mate.academy

@JvmInline
value class TransactionId (val transactionId: String) {
    init {
        require(transactionId.isNotBlank())
    }
}
