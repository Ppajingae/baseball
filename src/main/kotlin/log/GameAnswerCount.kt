package org.example.log

import org.example.data.DataManagement

class GameAnswerCount:DataManagement {
    private var count: Int = 0


    fun save() {
        count++
    }

    override fun get(): Int {
        return count
    }

    fun firstSave(){
        count = 0
    }
}