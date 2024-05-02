package org.example.answer

class Answer {

    private var answerRange = (111..999)
    private var isZero = false

    fun randomNumber():Int {
        if(!isZero) {
            println("zero")
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
                    numberString[2] != numberString[0]
        }.random()
    }

    fun setIsZero(isZero:Boolean){
        this.isZero = isZero
    }

}