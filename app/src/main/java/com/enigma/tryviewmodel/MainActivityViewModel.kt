package com.enigma.tryviewmodel

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var helloWord ="234"

    fun sayHello(word:String){
        helloWord = word
    }
}