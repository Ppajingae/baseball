package org.example.io

import org.example.enumset.GameRule
import java.io.BufferedReader

class GameInput:Io {
    override fun input(bufferedReader: BufferedReader): String {
        println("\n")
        println("<<<   슛자 야구 게임에 오신 것일 환영 합니다!!   >>>")
        println("1부터 9까지의 숫자를 ${GameRule.LENGTH.number}자리 숫자로 중복 없이 입력 해주세요")
        return bufferedReader.readLine()
    }

    fun nextInput(bufferedReader: BufferedReader):String {
        println()
        println("1부터 9까지의 숫자를 ${GameRule.LENGTH.number}자리 숫자로 중복 없이 입력 해주세요")
        return bufferedReader.readLine()
    }
}