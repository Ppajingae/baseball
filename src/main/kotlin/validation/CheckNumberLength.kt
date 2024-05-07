package org.example.validation

import org.example.enumset.GameRule


class CheckNumberLength:ValidatorInterface {
    private val checkDuplicatedNumber = CheckDuplicatedNumber()
    private var userAnswer = ""

    override fun get(userAnswer: String, message:String): Boolean {
        this.userAnswer = userAnswer
        if (userAnswer.length != GameRule.LENGTH.number){
            println(message)
            return false
        }
        return true
    }

    override fun nextValid(get: Boolean):Boolean {
        return if(get){
            checkDuplicatedNumber.get(userAnswer, "값은 세자리 숫자만 가능 합니다")
        }else{
            false
        }
    }
}