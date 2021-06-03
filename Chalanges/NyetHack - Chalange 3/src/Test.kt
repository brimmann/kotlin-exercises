fun nameIsLong(name: String): Boolean{
    println(name)
    return name.length >= 20
}
fun playerCreateMessage(nameTooLong: Boolean): String {
    return if (nameTooLong) {
        "Name is too long. Please choose another name."
    } else {
        "Welcome, adventurer"
    }
}

fun main() {
    "Polarcubis, Supreme Master of NyetHack"
            .run(::nameIsLong)
            .run(::playerCreateMessage)
            .run(::println)
}