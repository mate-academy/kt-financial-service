package mate.academy.models

import org.jetbrains.annotations.NotNull

@JvmInline
value class TransactionId(@NotNull val transactionId: String) {
    init {
        require(transactionId != "") {
            throw IllegalArgumentException("Illegal argument")
        }
    }
}
