package me.chnu.enumdialect

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
class EnumDialectApplication

fun main(args: Array<String>) {
    runApplication<EnumDialectApplication>(*args)
}
