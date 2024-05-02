package org.example.log

import org.example.data.DataManagement

class GameLog:DataManagement {
    private var gameCountList = mutableListOf<Int>()
    private var gameAnswerCountList = mutableListOf<Int>()

    fun save(gameCount: Int, gameAnswerCount: Int) {
        gameCountList.add(gameCount)
        gameAnswerCountList.add(gameAnswerCount)
    }

    override fun get():Int{
        println("< 게임 기록 보기 >")
        println()
        if (gameCountList.size == 0){
            println("   << 게임 기록이 없습니다 >>   ")
            println()
        }
        gameCountList.forEachIndexed{ index, it ->
            println("$it 번째 게임 : 시도 횟수 - < ${gameAnswerCountList[index]} >\n")
        }

        return 2
    }

}