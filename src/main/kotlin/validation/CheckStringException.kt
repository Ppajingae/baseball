package org.example.validation

class CheckStringException:ValidatorInterface {
    override fun get(userAnswer: String): Boolean {
        try {
            userAnswer.forEach {
                if(it == '0'){
                    println("숫자는 1부터 9까지만 입력 가능 합니다")
                    return false
                }
            }
            userAnswer.toInt()
            return true
        }catch (e:NumberFormatException){
            println("문자는 입력할 수 없습니다")
            return false
        }
    }
}