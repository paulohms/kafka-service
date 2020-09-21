package br.com.kafkaservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
@EnableKafka
class KafkaServiceApplication

fun main(args: Array<String>) {
	runApplication<KafkaServiceApplication>(*args)
}
