package mate.academy
const val ACCOUNT_LENGTH = 10
@JvmInline
value class AccountNumber(val number : String) {
    init {
        require(number.length == ACCOUNT_LENGTH)
        require(!number.contains("[a-zA-Z]".toRegex()))
    }

}
