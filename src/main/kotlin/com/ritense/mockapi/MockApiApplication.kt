package com.ritense.mockapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MockApiApplication

fun main(args: Array<String>) {
    runApplication<MockApiApplication>(*args)
}
