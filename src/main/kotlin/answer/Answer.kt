package org.example.answer

import org.example.data.DataManagement

class Answer {

    private val answerRange = (111..999)

    fun randomNumber():Int {
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

}