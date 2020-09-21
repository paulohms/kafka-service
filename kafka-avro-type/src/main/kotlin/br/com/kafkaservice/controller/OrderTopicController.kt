package br.com.kafkaservice.controller

import br.com.kafkaservice.model.Order
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

    @PostMapping("/avro")
    fun sendMessage(@RequestBody order: Order): ResponseEntity<Order> {
        val result = kafkaProducerService.sendAvroMessage(topicName, order)
        return ResponseEntity.ok(order)
    }

}