package mate.academy

@JvmInline
value class TransactionId(val id: String) {
    init {
        require(id.isNotEmpty()) { "Transaction Id can't be empty" }
    }

    override fun toString(): String {
        return id
    }
}
