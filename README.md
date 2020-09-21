# kafka-service

PoC realizada após a leitura do livro *Kafka - The Definitive Guide*. 

Tecnologias utilizadas:

* Kotlin
* Maven
* Spring Boot 
* Avro


Para execução, seguir os passos abaixo:

```
docker-compose up
```

Para criação de um novo tópico:

```
docker-compose exec kafka kafka-topics --create --topic order-topic --partitions 2 --replication-factor 1 --if-not-exists --zookeeper zookeeper:2181
```

Para detalhes do tópico criado:

```
docker-compose exec kafka kafka-topics --describe --topic order-topic --zookeeper zookeeper:2181
```

Para consumir as mensagens manualmente:

```
docker-compose exec kafka kafka-console-consumer --bootstrap-server localhost:29092 --topic order-topic --from-beginning
```


