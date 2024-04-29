package org.example

enum class ResultString(judgment:String){
    STRIKE("S"),
    BALL("B"),
    NOTTING("NOTTING");

    companion object{
        fun getJudgment(judgment:String):String{
            return judgment
        }
    }
}

