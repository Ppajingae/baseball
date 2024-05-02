package org.example.game

import org.example.answer.Answer
import org.example.enumset.GameRule
import org.example.io.GameInput
import org.example.log.GameAnswerCount
import org.example.log.GameCount
import org.example.log.GameLog
import org.example.validation.CheckDuplicatedNumber
import org.example.validation.CheckNumberLength
import org.example.validation.CheckStringException
import org.example.validation.Validator
import java.io.BufferedReader
import java.io.InputStreamReader

class Game {
    private val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    private val validator = Validator()
    private val gameInput = GameInput()
    private val gameCount = GameCount()
    private val gameAnswerCount = GameAnswerCount()

    fun run(answer: Answer, gameLog: GameLog, rule:Int) {
        gameCount.save()
        gameAnswerCount.firstSave()
        val computerAnswer = answer.randomNumber().toString()
        var userAnswer:String

        while (true) {

            userAnswer = if(gameAnswerCount.get() == 0) gameInput.input(bufferedReader) else gameInput.nextInput(bufferedReader)
            gameAnswerCount.save()



            if (!validator.getValid(CheckStringException(),userAnswer, "숫자는 ${rule}부터 9까지만 입력 가능 합니다")) continue
            if (!validator.getValid(CheckNumberLength(),userAnswer, "값은 세자리 숫자만 가능 합니다")) continue
            if (!validator.getValid(CheckDuplicatedNumber(),userAnswer, "해당 게임은 중복 값이 존재할 수 없습니다")) continue

            if (gameLogic(computerAnswer, userAnswer, gameLog)) break

        }

    }

    private fun gameLogic(computerAnswer: String, userAnswer: String, gameLog: GameLog):Boolean {
        var strikeCount = 0
        var ballCount = 0
        var nothingCount = 0


        computerAnswer.forEachIndexed{ index, it ->
            if(it == userAnswer[index]) strikeCount++
            else if(it in userAnswer) ballCount++

            nothingCount = GameRule.LENGTH.number - (strikeCount + ballCount)

            if(strikeCount == 3){
                //게임이 종료가 될 경우 게임 로그 클래스 에 그동안 저장한 데이터를 전부 넘겨주고 종료
                println("정답 입니다")
                gameLog.save(gameCount.get(), gameAnswerCount.get())
                println("질문을 한 횟수 : ${gameAnswerCount.get()}")
                return true
            }
        }


        println("$strikeCount STRIKE / $ballCount BALL / $nothingCount NOTHING")

        return false
    }

}