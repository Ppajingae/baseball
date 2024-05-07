package org.example.answer

import org.example.enumset.GameRule

class Answer {

    private var answerRange = (111..999)
    private var isZero = false

    fun randomNumber():Int {
        if(!isZero) {
            return answerRange.filter {
                val numberString = it.toString()
                numberString[0] != numberString[1] &&
                        numberString[1] != numberString[2] &&
                        numberString[2] != numberString[0] &&
                        numberString[0] != '0' &&
                        numberString[1] != '0' &&
                        numberString[2] != '0'
            }.random()
        }

        return answerRange.filter {
            val numberString = it.toString()
            numberString[0] != numberString[1] &&
                    numberString[1] != numberString[2] &&
                    numberString[2] != numberString[0] &&
                    numberString[0] != '0'
        }.random()
    }

    fun setIsZero(isZero:Boolean){
        if(isZero){
            answerRange = (102..999)
        }
        this.isZero = isZero
    }

    fun ruleConfirm():Boolean{
        return isZero
    }
}