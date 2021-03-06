import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyle's Folly"

var playerGold = 10
var playerSilver = 10
var dragonsBreathAmount = 5.0f
fun main() {
    placeOrder("shandy, Dragon's Breath, 5.91")

}

fun performPurchase(price: Double){
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")

    val remainingBalance = totalPurse - price
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    val remainedGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainedGold
    playerSilver = remainingSilver
    displayBalance()
}

private fun displayBalance(){
    println("Player's purse balance: Gold: $playerGold, Silver: $playerSilver")
}

private fun toDragonSpeak(phrase: String) = phrase.replace(Regex("[aeiou]")){
    when(it.value){
        "a" -> "4"
        "e" -> "3"
        "i" -> "1"
        "o" -> "0"
        "u" -> "|_|"
        else -> it.value
    }
}

private fun placeOrder(menuData: String){
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")
    val (type, name, price) = menuData.split(',')
    val nameTrimmed = name.trim()
    val message = "Madrigal buys a $name ($type) for $price"
    println(message)

    performPurchase(price.toDouble())

    val phrase = if(nameTrimmed == "Dragon's Breath"){
        "Madrigal exclaims ${toDragonSpeak("Ah, delicious $nameTrimmed")}"
    } else {
        "Madrigal says: Thanks fo the $name."
    }
    println(phrase)
}


private fun gallonsToPints(inputGallons: Float){
}

private fun displayRemainingInPints(inputGallons: Float){

}

