package org.example.game

import org.example.ResultString
import org.example.answer.Answer
import org.example.io.Io
import org.example.validation.CheckDuplicatedNumber
import org.example.validation.CheckNumberLength
import org.example.validation.CheckStringException
import org.example.validation.Validator
import java.io.BufferedReader
import java.io.InputStreamReader

class Game {

    fun run() {
        val getAnswer = Answer().get()
        while (true) {
            val userAnswer = Io().input(BufferedReader(InputStreamReader(System.`in`)))

            if (!Validator().getValid(CheckNumberLength(),userAnswer)) continue
            if (!Validator().getValid(CheckStringException(),userAnswer)) continue
            if (!Validator().getValid(CheckDuplicatedNumber(),userAnswer)) continue

            if(gameLogic(getAnswer, userAnswer)) break

        }

    }

    private fun gameLogic(answer: Int, userAnswer: String):Boolean {
        Answer().gameCounting()
        //같은 자리에 같은 숫자가 있을 경우 스트라이크
        println(answer)
        val answerToString = answer.toString()
        var strikeCount = 0
        var ballCount = 0
        var nothingCount = 0

        answerToString.forEachIndexed{ index, it ->
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
                return true
            }
        }




        println("$strikeCount ${ResultString.getJudgment("S")} / $ballCount ${ResultString.getJudgment("B")} / $nothingCount ${ResultString.getJudgment("NOTHING")}")

        return false
    }

}