package mate.academy.models

import org.jetbrains.annotations.NotNull

@JvmInline
value class AccountNumber(val accountNumber: String) {
    init {
        require(accountNumber.matches(Regex("^\\d{10}$"))) {
            throw IllegalArgumentException("Illegal argument")
        }
    }
}
