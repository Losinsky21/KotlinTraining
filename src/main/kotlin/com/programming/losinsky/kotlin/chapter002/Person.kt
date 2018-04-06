package com.programming.losinsky.kotlin.chapter002

class Person (val firstName: String, val lastName: String, val age: Int){
    init { // add code to constructor
        require(firstName.trim().length > 0) {"Invaild firstName argument!"}
        require(lastName.trim().length > 0) {"Invaild lastName argument!"}
        require(age in 0..130) {"Invaild age argument!"}
    }

    constructor( firstName: String,  lastName: String) : this(firstName, lastName, 0) // Kotlin has default values, explain in later code
}