package org.example.validation

class CheckDuplicatedNumber:ValidatorInterface {
    override fun get(userAnswer: String): Boolean {
        val arrayUser = userAnswer.toList()
        if(arrayUser.size != arrayUser.distinct().size){
            println("해당 게임은 중복 값이 존재할 수 없습니다")
            return false
        }
        return true
    }
}