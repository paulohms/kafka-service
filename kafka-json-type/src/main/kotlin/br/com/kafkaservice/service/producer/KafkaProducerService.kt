package br.com.kafkaservice.service.producer

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import org.springframework.util.concurrent.ListenableFuture

@Service
class KafkaProducerService(val kafkaTemplate: KafkaTemplate<String, String>) {

    fun sendTextMessage(topic: String, message: String): ListenableFuture<SendResult<String, String>> = kafkaTemplate.send(topic, message)

}