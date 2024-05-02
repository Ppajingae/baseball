package org.example

import org.example.io.StartInput
import org.example.menu.Menu
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val startInput = StartInput()
    val menu = Menu()

    while (true) {
        val selectMenuNumber = startInput.input(bufferedReader)

        val getMenu = menu.main(selectMenuNumber)

        if (getMenu == 3) {
            break
        }
    }

}