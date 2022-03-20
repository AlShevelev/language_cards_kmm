package com.shevelev.languagecards

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}