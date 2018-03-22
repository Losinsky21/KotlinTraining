package com.programming.losinsky.kotlin.chapter001

import com.programming.losinsky.kotlin.chapter001.constants.*
import com.programming.losinsky.kotlin.chapter001.FirstClassPackage.Foo as Foo
import com.programming.losinsky.kotlin.chapter001.SecondClassPackage.Foo as Foo2

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

    println(rawString)

    // ********
    // Arrays

    val array = arrayOf(1,2,3,4,5,6,7,8,9,10) //equals to int[] in java
    val squareArray = IntArray(10, { number -> (number+1) * (number+1) })
    println(squareArray.forEach { xaa -> print("$xaa ") })

    // ******
    // imports - alias cannot be used for import ....class.* (for * import)

    println(PII + EE)
    println(Foo().get())
    println(Foo2().get())


}