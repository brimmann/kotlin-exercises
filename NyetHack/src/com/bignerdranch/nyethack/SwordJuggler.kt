package com.bignerdranch.nyethack

import java.lang.Exception
import java.lang.IllegalStateException

fun main() {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if(isJugglingProficient){
        swordsJuggling = 2
    }

    try{
        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)
    }catch(e: Exception){
        println(e)
    }

    println("You juggle $swordsJuggling sword(s)!")
}

fun proficiencyCheck(swordsJugglin: Int?){
    checkNotNull(swordsJugglin, {"com.bignerdranch.nyethack.Player cannot juggle swords"})
}

class UnskilledSwordJugglerException() : IllegalStateException("com.bignerdranch.nyethack.Player cannot juggle swords")