package com.programming.losinsky.kotlin.chapter002

class Person02(firstName: String, lastName: String, age: Int) {


    // just testing different case
    // private val _firstName: String = firstName
    // private val _age = age


    private val _firstName: String
    private val _age: Int

    init {
        this@Person02._firstName = firstName
        this@Person02._age = age
    }

    fun getName(): String {

        return _firstName
        // return this@Person02._firstName
    }

    fun getAge(): Int {

        return _age
        // return this@Person002._age
    }
}