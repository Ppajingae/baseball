package org.example.validation

import org.example.answer.Answer
import org.example.game.Game
import org.example.log.GameLog

class Validator {

    fun getValid(validator: ValidatorInterface, userAnswer: String) = validator.get(userAnswer)


    fun gameMenu(str: String){
        try {
            when(str){
                "1" -> Game().run()
                "2" -> GameLog().result()
                "3" -> println("종료 합니다")
                else -> throw Exception("값을 잘못 입력 했습니다 다시 입력 해주세요")
            }
        }catch (e: Exception){
            println(e)
        }


    }
}