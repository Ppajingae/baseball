package org.example.validation

import org.example.enumset.GameRule


class CheckNumberLength:ValidatorInterface {
    override fun get(userAnswer: String, message:String): Boolean {
        if (userAnswer.length != GameRule.LENGTH.number){
            println(message)
            return false
        }
        return true
    }
}