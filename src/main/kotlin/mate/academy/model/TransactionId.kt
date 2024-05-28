package mate.academy.model

@JvmInline
value class TransactionId(val id: String) {
    init {
        require(id.isNotEmpty()) { "id shouldn't be empty" }
    }
}
