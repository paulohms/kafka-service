package br.com.kafkaservice.config

import io.confluent.kafka.serializers.KafkaAvroDeserializer
import io.confluent.kafka.serializers.KafkaAvroSerializer
import org.apache.avro.generic.GenericRecord
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
class ProducerConfig {

    @Value("\${kafka.host}")
    private val host: String? = null

    companion object {
        const val SCHEMA_REGISTRY = "schema.registry.url"
        const val SCHEMA_REGISTRY_SERVER = "http://localhost:8081"
    }

    @Bean
    fun producerFactory(): ProducerFactory<String, GenericRecord> {
        val configProps = mapOf<String, Any>(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to "$host",
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to KafkaAvroSerializer::class.java,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to KafkaAvroDeserializer::class.java,
                SCHEMA_REGISTRY to SCHEMA_REGISTRY_SERVER)

        return DefaultKafkaProducerFactory(configProps)
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, GenericRecord> {
        return KafkaTemplate(producerFactory())
    }

}