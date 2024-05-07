package org.example.menu

import org.example.answer.Answer
import org.example.game.Game
import org.example.io.SubMenuInput
import org.example.log.GameLog
import java.io.BufferedReader
import java.io.InputStreamReader

class SubMenu {
    private val answer = Answer()
    private val game = Game()
    private val subMenuInput = SubMenuInput()
    private val bufferedReader = BufferedReader(InputStreamReader(System.`in`))


    fun get(gameLog: GameLog):Int{
        val str = subMenuInput.input(bufferedReader)
        try {
            when(str){
                "1" -> {
                    answer.setIsZero(true)
                    game.run(gameLog = gameLog, answer = answer, rule = 0)
                    return 1
                }
                "2" -> {
                    answer.setIsZero(false)
                    game.run(gameLog = gameLog, answer = answer, rule = 1)
                    return 1
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