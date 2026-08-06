package mate.academy.util

fun String.toSingleLine(): String = this.trimIndent().replace(Regex("[\n\r]"), "")
