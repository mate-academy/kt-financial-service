package mate.academy.models

private const val ACCNUMLENGTH = 10

@JvmInline
    value class AccountNumber (val amountNumber: String) {
        init {
            require(amountNumber.length == ACCNUMLENGTH) {"Acount number must be exactly 10 characters"}
            require(amountNumber.all { it.isDigit() }) {"Account number must contain only digits"}
        }
    }
