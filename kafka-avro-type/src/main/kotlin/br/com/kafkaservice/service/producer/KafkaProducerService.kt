package br.com.kafkaservice.service.producer

import br.com.kafkaservice.model.Order
import org.apache.avro.Schema
import org.apache.avro.generic.GenericRecord
import org.apache.avro.generic.GenericRecordBuilder
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import java.io.File

@Service
class KafkaProducerService(val kafkaTemplate: KafkaTemplate<String, GenericRecord>) {

    private val schema = Schema.Parser().parse(File("kafka-avro-type/src/main/resources/order.avsc"))

    fun sendAvroMessage(topic: String, order: Order): SendResult<String, GenericRecord>? {

        var avroOrder = GenericRecordBuilder(schema).apply {
            set("name", order.name)
            set("address", order.address)
        }.build()

        val futureResult = kafkaTemplate.send(ProducerRecord<String, GenericRecord>(topic, avroOrder))

        return futureResult.get()
    }

}