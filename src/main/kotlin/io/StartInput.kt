package org.example.io

import org.example.validation.Validator
import java.io.BufferedReader

class StartInput:Io() {
    override fun input(bufferedReader: BufferedReader):String {
        println("환영 합니다! 원하 시는 번호를 입력 해주세요")
        println("1. 게임 시작 하기  2. 게임 기록 보기  3. 종료 하기")

        return super.input(bufferedReader)
    }
}