

import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
    val squareCabin = SquareCabin(6, 50.0)
    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 15.5)

    with(squareCabin) {
        println("\nSquare Cabin\n============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Floor area: ${floorArea()}")
    }

    with(roundHut) {
        println("\nRound Hut\n=========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Floor area: ${floorArea()}")
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Carpet size: ${calculateMaxCarpetLength()}")
    }

    with(roundTower) {
        println("\nRound Tower\n==========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Floor area: ${floorArea()}")
        println("Carpet Length: ${calculateMaxCarpetLength()}")
    }
}


abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int


    abstract fun floorArea(): Double


    fun hasRoom(): Boolean {
        return residents < capacity
    }


    fun getRoom() {
        if (capacity > residents) {
            residents++
            println("You got a room!")
        } else {
            println("Sorry, at capacity and no rooms left.")
        }
    }

}


class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
    override val buildingMaterial = "Wood"
    override val capacity = 6


    override fun floorArea(): Double {
        return length * length
    }

}


open class RoundHut(
    residents: Int, val radius: Double) : Dwelling(residents) {

    override val buildingMaterial = "Straw"
    override val capacity = 4


    override fun floorArea(): Double {
        return PI * radius * radius
    }


    fun calculateMaxCarpetLength(): Double {
        return sqrt(2.0) * radius
    }

}


class RoundTower(
    residents: Int,
    radius: Double,
    val floors: Int = 2) : RoundHut(residents, radius) {

    override val buildingMaterial = "Stone"

    // Capacity depends on the number of floors.
    override val capacity = floors * 4


    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}