package mate.academy.model

const val EMPTY_ID = "ID transaction cannot be empty."

@JvmInline
value class TransactionId(val id: String) {
    init {
        require(id.isNotBlank()) {
            EMPTY_ID
        }
    }
}
