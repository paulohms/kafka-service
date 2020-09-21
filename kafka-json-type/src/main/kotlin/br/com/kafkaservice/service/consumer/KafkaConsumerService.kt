package br.com.kafkaservice.service.consumer

import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Slf4j
@Service
class KafkaConsumerService {

    val log: Logger = LoggerFactory.getLogger(KafkaConsumerService::class.java)

    @KafkaListener(topics = ["order-topic"], groupId = "order-topic-consumer")
    fun processMessage(message: String) {
        log.info("Received message -> $message")
    }

}