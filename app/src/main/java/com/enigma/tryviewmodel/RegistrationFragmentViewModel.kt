package com.enigma.tryviewmodel

import androidx.lifecycle.ViewModel

class RegistrationFragmentViewModel : ViewModel() {

    fun inputNameValidation(name:String):Boolean = !name.isNullOrBlank()

}