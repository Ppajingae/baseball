package org.example.validation

import org.example.answer.Answer

class CheckStringException:ValidatorInterface {
    private val answer = Answer()
    private val checkNumberLength = CheckNumberLength()
    private var userAnswer = ""
    override fun get(userAnswer: String, message:String): Boolean {
        this.userAnswer = userAnswer
        try {
            for(i in 0..userAnswer.length - 1) {
                if(answer.ruleConfirm()){
                    if(userAnswer[i] == '0'){
                        println(message)
                        return false
                    }
                }
                if(userAnswer[0] == '0'){
                    println("앞 자리가 0이 될 수는 없습니다")
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

    override fun nextValid(get: Boolean):Boolean {
        return if(get){
            checkNumberLength.get(userAnswer, "해당 게임은 중복 값이 존재할 수 없습니다")
        }else{
            false
        }
    }

}