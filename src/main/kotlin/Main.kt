package org.example

import org.example.io.StartInput
import org.example.validation.Validator
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))

    val selectMenuNumber = StartInput().input(bufferedReader)

    Validator().gameMenu(selectMenuNumber)

}