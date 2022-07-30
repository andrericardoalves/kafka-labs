package com.system.consumer.kafka.listeners;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StringConsumerListener {

    @KafkaListener(groupId = "group-0",
            topicPartitions = {
                @TopicPartition(topic = "kafka-topic", partitions = {"0"})
            },
            containerFactory = "concurrentKafkaListenerContainerFactory")
    public void create(String message){

        log.info("CREATE ::: Receive message {} ", message);
    }

    @KafkaListener(groupId = "group-1",
            topicPartitions = {
                    @TopicPartition(topic = "kafka-topic", partitions = {"1"})
            },
            containerFactory = "concurrentKafkaListenerContainerFactory")
    public void log(String message){

        log.info("LOG ::: Receive message {} ", message);
    }

    @KafkaListener(groupId = "group-2", topics = "kafka-topic",
            containerFactory = "concurrentKafkaListenerContainerFactory")
    public void history(String message){

        log.info("HISTORY ::: Receive message {} ", message);
    }
}
