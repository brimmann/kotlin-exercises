import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyle's Folly"

var playerGold = 10
var playerSilver = 10
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableListOf<String>()
val menuList = File("data/tavern-menu-data.txt").readText().split("\n")
fun main() {
    displayMenu()
    for(item in menuList) item.trim()
    if(patronList.contains("Eli")){
        println("The tavern master says: Eli's in the back playing cards.")
    }else{
        println("The tavern master says: Eli isn't here.")
    }

    if(patronList.containsAll(listOf("Sophie", "Mordoc"))){
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    }else{
        println("The tavern master says: Nay, they departed hours ago.")
    }

    (0..9).forEach{ _ ->
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }
    println(uniquePatrons)

    var orderCount = 0
    while(orderCount <= 9){
        placeOrder(uniquePatrons.shuffled().first(), menuList.shuffled().first())
        orderCount++
    }
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

private fun placeOrder(patronName: String, menuData: String){
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")
    val (type, name, price) = menuData.split(',')
    val nameTrimmed = name.trim()
    println("$patronName buys a $nameTrimmed ($type) for $price")

//    performPurchase(price.toDouble())

    val phrase = if(nameTrimmed == "Dragon's Breath"){
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "$patronName says: Thanks fo the $name."
    }
    println(phrase)
}

private fun displayMenu(){
    val menuItemsName = mutableListOf<String>()
    val menuItemPrice = mutableListOf<String>()

    val cateMenu = mutableListOf<String>()
    val shandyMenu = mutableListOf<String>()
    val elixirMenu = mutableListOf<String>()
    val mealMenu = mutableListOf<String>()
    val desMenu = mutableListOf<String>()

    menuList.forEach {
        val (type, name, price) = it.split(',')
        name.trim()
        menuItemsName += name
        price.trim()
        val temp = price.toFloat()
        menuItemPrice += temp.toString()
    }

    var longestString = 0
    menuItemsName.forEach{
        if(it.length >= longestString) longestString = it.length
    }
    longestString += 15
    var loopCounter = 0

    while(loopCounter < menuItemsName.size){
       if()
    }
}



