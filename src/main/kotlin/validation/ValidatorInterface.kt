package org.example.validation

interface ValidatorInterface {

    fun get(userAnswer: String, message: String): Boolean
}