package org.example.menu

import org.example.log.GameLog

class Menu {
    private val gameLog = GameLog()
    private val subMenu = SubMenu()

    fun main(str: String):Int{
        try {
            when(str){
                "1" -> {
                    return subMenu.get(gameLog)
                }
                "2" -> {
                    return gameLog.get()
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