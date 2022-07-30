package com.system.consumer.kafka.listeners;

import com.system.consumer.kafka.custom.StringConsumerCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StringConsumerListener {
    @StringConsumerCustomListener(groupId = "group-1")
    public void create(String message){

        log.info("CREATE ::: Receive message {} ", message);
    }

    @StringConsumerCustomListener(groupId = "group-1")
    public void log(String message){

        log.info("LOG ::: Receive message {} ", message);
    }

    @StringConsumerCustomListener(groupId = "group-2")
    public void history(String message){

        log.info("HISTORY ::: Receive message {} ", message);
    }
}
