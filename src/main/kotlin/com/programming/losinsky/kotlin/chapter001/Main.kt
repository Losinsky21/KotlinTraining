package com.programming.losinsky.kotlin.chapter001

import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.util.*
import com.programming.losinsky.kotlin.chapter001.FirstClassPackage.Foo as Foo
import com.programming.losinsky.kotlin.chapter001.SecondClassPackage.Foo as Foo2
import com.programming.losinsky.kotlin.chapter002.Person as Person002

fun main (args: Array<String>)
{
    println("Hello World!")

    // *********
    // bitwise operators
    // lewo - najstarszy bit (skrajny lewy)) jest tracony, w miejsce najmłodszego (skrajny prawy) dopisywane jest 0 - mnozenie * 2
    // prawo - najmlodszy bit (skrajny prawy) jest tracony, w miejsce najmlodszego (skrajny lewy) dopisywane jest 0 - dzielenie / 2

    val leftShift = 104 shl 1
    val rightShift = 1024 shr 1
    val invOne = 16.inv()

    //println("$leftShift - $rightShift")
    //println(invOne)

    // ********
    // booleans

    val x = 5
    val z = 2
    val y = 3

    val xIsBiggest = x > y && x > z
    val zIsBiggest = z > x && z > y

    //println("Z is biggest: $zIsBiggest, X is biggest: $xIsBiggest")

    // ********
    // Strings

    val rawString = """With raw strings you can do weird things
        just like this
        no need to use break line"""

    //println(rawString)

    // ********
    // Arrays

    val array = arrayOf(1,2,3,4,5,6,7,8,9,10) //equals to int[] in java
    val squareArray = IntArray(10, { number -> (number+1) * (number+1) })
    //println(squareArray.forEach { xaa -> print("$xaa ") })

    // ******
    // imports - alias cannot be used for import ....class.* (for * import)

    //println(PII + EE)
    //println(Foo().get())
    //println(Foo2().get())

    // ********
    // ranges

    val aToZ = 'a'..'z'
    val zeroToNine = 0..9

    val containsInLowerCaseAlphabet = 'd' in aToZ
    val isDigit = 11 in zeroToNine

    val countingDown = 100.downTo(0)
    val rangeTo = 10.rangeTo(20)

    val oneToFifty = 1..50
    val otfNumbers = oneToFifty.step(2)

    val countingDownNumbers = (0..100).step(2).reversed()

    //println(containsInLowerCaseAlphabet)
    //println(isDigit)
    //println(countingDown.forEach{x -> print("$x ")})

    // ********
    // Loops

    val list = listOf(1,2,3,4)
    val set = setOf(1,2,3,4,5,6,7,8,9)

    for (X in list.indices)
    {
        print("Position $X - Number ${list[X]}\n")
    }

    // ************
    // oop

    // EQUALITY
    val a = File("/mobydick.dcc")
    val b = File("/mobydick.dcc")


    val sameReference = a === b
    val sameValue = a == b

    // println(sameReference)
    // println(sameValue)

    // THIS

    val person = Person("Mirek")

    //person.printContent()

    // ************
    // control flows as expressions

    // println("This is sometext".startsWith("T"))
    // println("This is some text".contains("teXt".toLowerCase()))

    val date = Date()
    val today = date.year == 2018

    // println(today)

    val success = try {
        // readFile()
        true
    } catch (e: IOException) {
        false
    }

    // ********************
    // type casting and checking
    // println(isInteger(20))

    //smart cast
    // println(printStringLength("String to test length function"))
    // println(isNotStringOrEmpty("This should return false"))
    //println(lengthFromString(200))

    // *************
    // WHEN expression (like switch in Java)


    oneOrZero(20)
    println(isSingleDigit(10))
    println(biggerValue(21, 20))

    printEvenNumbers(listOf(1, 22, 30, 11, 46, 74, 42, 0, 9))

    print(printValue(listOf(1, 2, 3, 6, 7, 324, 234, 325, 25, 532, 43)))
}

fun isZero (x: Int) : Boolean {

    return if (x == 0) true else false
}

fun readFile (path: Path) {
    val input = Files.newInputStream(path)

    try {
        var byte = input.read()
        while (byte != 1)
        {
            println(byte)
            byte = input.read()
        }
    }
    catch (e: IOException) {
        println("No file found. ${e.message}")
    }
    finally {
        input.close()
    }
}

fun isInteger (any: Any) : Boolean {

    return (any is Int)
}

fun printStringLength(any: Any) : Int {

    return if (any is String) any.length else -1
}

fun isNotStringOrEmpty(any: Any) : Boolean {

    return any !is String || any.length == 0
}

fun lengthFromString(any: Any): Int { // i dont get this smart cast -- TO STUDY LATER --

    val returnLength: String? = any as String
    return returnLength!!.length
}

fun oneOrZero (x: Int) : Boolean {

   return when (x) {
       0,1 -> true
       else -> false
   }
}

fun isSingleDigit (x: Int) : Boolean {

    return when (x) {
        in -9..9 -> true
        else -> false
    }
}

fun isNumberContainsList (x: Int) : Boolean {

    return when (x) {
        in listOf(1,3,5,7,9) -> true
        else -> false
    }
}

fun biggerValue (x: Int, y: Int) : Int {

    return when {
        x > y -> x
        y > x -> y
        else -> x
    }
}


// example of anonymous function
fun largestNumber (a: Int, b: Int, c: Int) : Int {

    fun largest(a: Int, b: Int) : Int {

        return when {
            a > b -> a
            else -> b
        }
    }

    return largest(largest(a,b),largest(b,c))
}

fun printEvenNumbers(list: List<Int>) {

    list.forEach{ x ->
        when {
            x % 2 == 0 -> print("$x ")
        }
    }
}

fun printValue (list: List<Int>) {

    list.forEach label@{
        if (it % 2 == 0) {
            //print("$it ")
            return@label
        }
    }
}
