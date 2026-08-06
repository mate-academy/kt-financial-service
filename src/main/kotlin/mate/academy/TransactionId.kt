package mate.academy

@JvmInline
value class TransactionId(val identifier: String) {
    init {
        require(!identifier.isBlank())
    }
}
