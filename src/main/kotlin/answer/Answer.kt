package org.example.answer

class Answer {
    private val answerRange = (111..999)
    private var gameCount = 0
    private var gameAnswerCount = 0

    fun get():Int {
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

    fun gameCounting(){
        gameCount++
    }

    fun gameAnswerCounting(){
        gameAnswerCount++
    }
}