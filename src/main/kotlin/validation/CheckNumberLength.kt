package org.example.validation

class CheckNumberLength:ValidatorInterface {
    override fun get(userAnswer: String): Boolean {
        if (userAnswer.length != 3){
            println("값은 111 ~ 999 까지 가능 합니다")
            return false
        }
        return true
    }
}