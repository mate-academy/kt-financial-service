package mate.academy

const val NECESSARY_LENGTH: Int = 10

@JvmInline
value class AccountNumber(val number: String) {
    init {
        require(number.length == NECESSARY_LENGTH && checkNumber(number))
    }

    fun checkNumber(string: String): Boolean {
        val chars = string.toCharArray()
        for (c in chars) {
            if (!c.isDigit()) {
                return false
            }
        }
        return true
    }
}
