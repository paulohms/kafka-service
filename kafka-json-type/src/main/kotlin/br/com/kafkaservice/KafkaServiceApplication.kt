package br.com.kafkaservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaServiceApplication

fun main(args: Array<String>) {
	runApplication<KafkaServiceApplication>(*args)
}
