package mate.academy

    @JvmInline
    value class AccountNumber(val number : String) {
        init {
            if(!number.matches(Regex("^\\d{10}\$"))) {
                throw IllegalArgumentException()
            }
        }
    }
