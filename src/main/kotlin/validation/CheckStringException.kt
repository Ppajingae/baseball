package org.example.validation

class CheckStringException:ValidatorInterface {
    override fun get(userAnswer: String, message:String): Boolean {
        try {
            userAnswer.forEach {
                if(it == '0'){
                    println(message)
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