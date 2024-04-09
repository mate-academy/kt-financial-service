package mate.academy

import org.jetbrains.annotations.NotNull

data class TransactionId(@NotNull var transactionId: String) {
    init {
        require(transactionId == "") {
            throw IllegalArgumentException()
        }
    }
}
