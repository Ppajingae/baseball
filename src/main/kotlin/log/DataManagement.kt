package org.example.log

abstract class DataManagement {

    open fun save(){
        println("저장 완료")
    }

    abstract fun get(): Int
}