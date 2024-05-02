package org.example.io

import java.io.BufferedReader

class SubInput:Io {
    override fun input(bufferedReader: BufferedReader): String {
        println("원하 시는 난이도를 입력 해주세요")
        println("1. 0이 있는 게임  2. 0이 없는 게임 3. 종료 하기")

        return bufferedReader.readLine()
    }
}