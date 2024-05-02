package org.example.log

class GameCount: DataManagement() {
    private var count: Int = 0

    override fun save(){
        count++
    }

    override fun get(): Int = count
}