package br.com.kafkaservice.controller

import br.com.kafkaservice.service.producer.KafkaProducerService
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("order-topic")
class OrderTopicController(val kafkaProducerService: KafkaProducerService) {

    @Value("\${order.topic}")
    private val topicName: String = ""

    @PostMapping("/json")
    fun sendMessage(@RequestBody message: String): ResponseEntity<String> {
        kafkaProducerService.sendTextMessage(topicName, message)
        return ResponseEntity.ok(message)
    }



}