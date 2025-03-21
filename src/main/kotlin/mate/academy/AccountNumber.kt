package mate.academy

    @JvmInline
    value class AccountNumber(val number : String) {
        init {
            require(!number.matches(Regex("^\\d{10}\$")),
                throw IllegalArgumentException("The value does not consist of 10 digits"))
        }
    }
