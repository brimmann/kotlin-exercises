import java.text.MessageFormat
import java.util.*

fun main() {
    val planet = 7
    val event = "a disturbance in the Force"
    val coco = "Hello!"

    val result = String.format(
        "{3} v At {1, time} on {1, date}, there was {2} on planet {0, number, integer}.",
        planet,
        Date(),
        event,
        coco
    )

    println(result)
}