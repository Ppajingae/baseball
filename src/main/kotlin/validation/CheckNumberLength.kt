package org.example.validation

import org.example.enumset.StringLength


class CheckNumberLength:ValidatorInterface {
    override fun get(userAnswer: String, message:String): Boolean {
        if (userAnswer.length != StringLength.LENGTH.number){
            println(message)
            return false
        }
        return true
    }
}