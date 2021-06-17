package com.example.demo

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
//@EnableAutoConfiguration(exclude = [DataSourceAutoConfiguration::class])
class SpringBootKotlinLearnApplication

fun main(args: Array<String>) {
	runApplication<SpringBootKotlinLearnApplication>(*args)
}
