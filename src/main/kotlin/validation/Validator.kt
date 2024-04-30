package org.example.validation

import org.example.log.GameLog

class Validator {

    fun getValid(validator: ValidatorInterface, userAnswer: String) = validator.get(userAnswer)

    fun getSBNottingValid(validator: ValidatorInterface, userAnswer: String,gameLog: GameLog) = validator.get(userAnswer)

}