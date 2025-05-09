package mate.academy

@JvmInline
value class TransactionId(val id: String) {

    init {
        require(id.isNotEmpty()) { "id must not be empty" }
    }

}
