package org.example.io

import java.io.BufferedReader

open class Io {

    open fun input(bufferedReader: BufferedReader):String{
        println("숫자를 입력 하세요")
        return bufferedReader.readLine()
    }

    fun output(){
        print("test")
    }
}