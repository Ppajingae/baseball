package org.example.log

import org.example.data.DataManagement

class GameLog:DataManagement {
    private var gameCount: Int = 0
    private var gameAnswerCount: Int = 0
    private var gameCountList = mutableListOf<Int>()
    private var gameAnswerCountList = mutableListOf<Int>()

    fun set(gameCount: Int, gameAnswerCount: Int) {
        gameCountList.add(gameCount)
        gameAnswerCountList.add(gameAnswerCount)
    }

    fun get(){
        println("< 게임 기록 보기 >")
        println()
        gameCountList.forEachIndexed{ index, it ->
            println("$it 번째 게임 : 시도 횟수 - < ${gameAnswerCountList[index]} >\n")
        }
    }

    fun gameCounting(){
        this.gameCount++
    }

    fun gameAnswerCounting(isCounting: Boolean){
        if(isCounting) this.gameAnswerCount++
        else this.gameAnswerCount = 0
    }

    override fun getGameCount(): Int = gameCount

    override fun getGameAnswerCount(): Int = gameAnswerCount
}