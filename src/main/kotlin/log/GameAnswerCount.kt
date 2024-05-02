package org.example.log

class GameAnswerCount: DataManagement() {
    private var count: Int = 0


    override fun save() {
        count++
    }

    override fun get(): Int {
        return count
    }

    fun firstSave(){
        count = 0
    }
}