package org.example.game

import org.example.ResultString
import org.example.answer.Answer
import org.example.io.Io
import org.example.log.GameLog
import org.example.validation.CheckDuplicatedNumber
import org.example.validation.CheckNumberLength
import org.example.validation.CheckStringException
import org.example.validation.Validator
import java.io.BufferedReader
import java.io.InputStreamReader

class Game {
    private val validator = Validator()

    fun run(answer: Answer, gameLog: GameLog) {
        gameLog.gameCounting()
        gameLog.gameAnswerCounting(false)
        val computerAnswer = answer.randomNumber().toString()

        while (true) {
            gameLog.gameAnswerCounting(true)
            val userAnswer = Io().input(BufferedReader(InputStreamReader(System.`in`)))

            if (!validator.getValid(CheckNumberLength(),userAnswer)) continue
            if (!validator.getValid(CheckStringException(),userAnswer)) continue
            if (!validator.getValid(CheckDuplicatedNumber(),userAnswer)) continue

            if(gameLogic(computerAnswer, userAnswer, gameLog)) break

        }

    }

    private fun gameLogic(computerAnswer: String, userAnswer: String, gameLog: GameLog):Boolean {
        //같은 자리에 같은 숫자가 있을 경우 스트라이크
        var strikeCount = 0
        var ballCount = 0
        var nothingCount = 0


        computerAnswer.forEachIndexed{ index, it ->
            if(it == userAnswer[index]) {
                strikeCount++

            }else{
                userAnswer.forEachIndexed{ userIndex, userIt ->
                    if(it == userIt) {
                        ballCount++
                    }
                }
            }
            nothingCount = 3 - (strikeCount + ballCount)

            if(strikeCount == 3){
                //게임이 종료가 될 경우 게임 로그 클래스 에 그동안 저장한 데이터를 전부 넘겨주고 종료
                println("정답 입니다")
                gameLog.set(gameLog.getGameCount(), gameLog.getGameAnswerCount())
                println("질문을 한 횟수 : ${gameLog.getGameAnswerCount()}")
                return true
            }
        }


        println("$strikeCount ${ResultString.STRIKE} / $ballCount ${ResultString.BALL} / $nothingCount ${ResultString.NOTTING}")

        return false
    }

}