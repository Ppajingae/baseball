package org.example.validation

import org.example.log.GameLog

class Validator {

    fun getValid(validator: ValidatorInterface, userAnswer: String, message:String) = validator.get(userAnswer, message)

    fun nextValid(validator: Boolean):Boolean{
        return validator
    }

}