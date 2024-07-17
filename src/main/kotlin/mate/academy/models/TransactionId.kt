package mate.academy.models

@JvmInline
    value class TransactionId (val id: String) {
        init {
            require (!id.isEmpty()) {"TransactionId cannot be empty"}
        }
    }
