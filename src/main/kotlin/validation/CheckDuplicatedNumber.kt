package org.example.validation

class CheckDuplicatedNumber:ValidatorInterface {

    override fun get(userAnswer: String, message:String): Boolean {
        val arrayUser = userAnswer.toList()
        if(arrayUser.size != arrayUser.distinct().size){
            println(message)
            return false
        }
        return true
    }

    override fun nextValid(get: Boolean): Boolean {
        if(!get){
            return false
        }else return true
    }
}