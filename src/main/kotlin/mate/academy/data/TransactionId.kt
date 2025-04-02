package mate.academy.data

import java.util.*

@JvmInline
value class TransactionId(val id: String) {
    init {
        require(id.isNotEmpty()) {
            "Id shouldn't be empty"
        }
    }
}