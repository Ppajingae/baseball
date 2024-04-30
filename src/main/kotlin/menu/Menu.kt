package org.example.menu

import org.example.answer.Answer
import org.example.game.Game
import org.example.log.GameLog

class Menu {
    private val gameLog = GameLog()
    private val answer = Answer()
    private val game = Game()

    fun gameMenu(str: String):Int{
        try {
            when(str){
                "1" -> {
                    game.run(gameLog = gameLog, answer = answer)
                    return 1
                }
                "2" -> {
                    gameLog.get()
                    return 2
                }
                "3" -> { println("< 숫자 야구 게임을 종료 합니다 >"); return 3 }
                else -> throw Exception("값을 잘못 입력 했습니다 다시 입력 해주세요")
            }
        }catch (e: Exception){
            println(e.message)
            return 0
        }


    }
}