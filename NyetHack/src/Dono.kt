import jnr.ffi.annotations.In

const val key = "monarchy"
var plainText = "Islamic University".toLowerCase()

fun main(args: Array<String>) {
    val t = encrypt()
    println(t)
    val r = decrypt(t)
    println(r)

}

fun encrypt(): String {

    val matrix = formMatrix()
    var cipherText = ""
    val plainTextPairs = formPairs(plainText)
    var encryptedLocation = emptyList<Int>()

    for(pair in plainTextPairs){
        val location = find(pair, matrix)
        encryptedLocation = if(location[1] == location[3]) listOf((location[0] + 1)%5, location[1], (location[2] + 1)%5, location[3])
        else if(location[0] == location[2]) listOf(location[0], (location[1] + 1)%5, location[2], (location[3] + 1)%5)
        else listOf(location[0], location[3], location[2], location[1])

        cipherText += matrix[encryptedLocation[0]][encryptedLocation[1]]
        cipherText += matrix[encryptedLocation[2]][encryptedLocation[3]]
    }

    return cipherText
}

fun decrypt(input: String): String{
    val matrix = formMatrix()
    var plainTextTemp = ""
    val cipherTextPairs = formPairs(input)
    var decryptedLocation = emptyList<Int>()
    var i1 = 0
    var j1 = 0
    var i2 = 0
    var j2 = 0

    for(pair in cipherTextPairs){
        val location = find(pair, matrix)

        decryptedLocation = if(location[1] == location[3]){
            i1 = (location[0] - 1)%5
            i2 = (location[2] - 1)%5
            if(i1 < 0){
                i1 = 4
            }
            if(i2 < 0){
                i2 = 4
            }
            listOf(i1 , location[1], i2 , location[3])
        }
        else if(location[0] == location[2]){
            i1 = (location[1] - 1)%5
            i2 = (location[3] - 1)%5
            if(i1 < 0){
                i1 = 4
            }
            if(i2 < 0){
                i2 = 4
            }
            listOf(location[0],j1 , location[2], j2)
        }
        else{
            listOf(location[0], location[3], location[2], location[1])
        }

        plainTextTemp += matrix[decryptedLocation[0]][decryptedLocation[1]]
        plainTextTemp += matrix[decryptedLocation[2]][decryptedLocation[3]]

    }

    return  plainTextTemp

}

fun formPairs(input: String): List<String> {
    var text = input
    if (input.length % 2 != 0) text = input + "z"
    return text.chunked(2)
}

private fun find(pair: String, keyMatrix: Array<CharArray>): List<Int> {

    var i1 = 0
    var j1 = 0
    var i2 = 0
    var j2 = 0

    for(i in 0..4){
        for(j in 0..4){
            if(pair[0] == keyMatrix[i][j]){
                i1 = i
                j1 = j
                break
            }
        }
    }



    for(i in 0..4){
        for(j in 0..4){
            if(pair[1] == keyMatrix[i][j]){
                i2 = i
                j2 = j
            }
        }
    }


    return listOf<Int>(i1, j1, i2, j2)
}

private fun formMatrix(): Array<CharArray> {

    val keyLength = key.length
    val allChars = "abcdefghiklmnopqrstuvwxz"
    var remainingChars = ""

    var notFound = true
    for(ch1 in allChars){
        notFound = true
        for (ch2 in key){
            if(ch1 == ch2){
                notFound = false
                break
            }
        }
        if(notFound) remainingChars += ch1
    }

    //println(remainingChars)

    val totalChars = key + remainingChars

    var matrix: Array<CharArray> = Array(5) { CharArray(5) }
    var index = 0;
    for(i in 0..4){
        for(j in 0..4){
            matrix[i][j] = totalChars[index]
            index += 1
        }

    }

    return matrix
}