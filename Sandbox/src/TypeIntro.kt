const val MAX_EXPERIENCE: Int = 5000

fun main() {
    val playerName = "Estragon"
    val playerNameReflection = playerName.reversed()
    var hasSteed = false
    val pubName = "Unicorn's Horn"
    val publicanOnDutyName = "Kordal"
    val playerGold = 50

    var experiencePoints = 5
    experiencePoints += 5
    println(experiencePoints)
    println(playerName)
    println(pubName)
    println(publicanOnDutyName)
    println(playerGold)
    println("Magic mirror: $playerNameReflection")
}