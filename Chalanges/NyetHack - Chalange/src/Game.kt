fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false
    val statusFormatString = "(HP)(A)(B) -> H"
    // Karma
    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 10).toInt()

    // Aura
    val auraColor = when(karma){
        in 0..5 -> "RED"
        in 6..10 -> "ORANGE"
        in 11..15 -> "PURPLE"
        in 16..20 -> "GREEN"
        else -> "DEFAULT"
    }
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal

    val healthStatus = when(healthPoints){
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if(isBlessed) "has some minor wounds but is healing quite quickly!" else "has some minor wounds."
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }
    val hp = "HP: $healthPoints"
    val h = "$name $healthStatus"
    val a = "Aura: ${if(auraVisible) auraColor else "NONE"}"
    val b = "Blessed: ${if(isBlessed) "YES" else "NO"}"
    val playerStatus = when(statusFormatString){
        "(HP)(A) -> H" -> "($hp)($a) -> $h"
        "(HP)(A)(B) -> H" -> "($hp)($a)($b) -> $h"
        "(HP)(B) -> H" -> "($hp)($b) -> $h"
        "(HP) -> H" -> "($hp) -> $h"
        else -> h
    }
    println(playerStatus)
}