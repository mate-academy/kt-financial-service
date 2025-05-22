package mate.academy

const val NUMBER_LENGTH = 10

@JvmInline
value class AccountNumber(val number: String) {
    init {
        require(number.length == NUMBER_LENGTH)
        require(number.all { it.isDigit() })
    }

    override fun toString(): String {
        return number.toString()
    }
}
