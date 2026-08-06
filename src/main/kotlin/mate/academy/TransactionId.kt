package mate.academy

@JvmInline
value class TransactionId(val id: String ) {
    init {
        require(id.isNotBlank()) {"Transaction ID must not be blank"}
    }

    override fun toString(): String {
        return id.toString()
    }


}
