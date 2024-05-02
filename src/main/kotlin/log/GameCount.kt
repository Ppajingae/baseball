package org.example.log

import org.example.data.DataManagement

class GameCount:DataManagement {
    private var count: Int = 0

    fun save(){
        count++
    }

    override fun get(): Int = count
}