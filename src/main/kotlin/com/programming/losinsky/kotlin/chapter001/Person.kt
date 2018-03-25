package com.programming.losinsky.kotlin.chapter001

class Person (val name: String) {

    fun printContent() {

        println(this)
    }

    inner class Worker (val profession: String)

    {
        fun getInfo() : String {

            return "${this@Person.name} - ${this.profession}"
        }
    }
}