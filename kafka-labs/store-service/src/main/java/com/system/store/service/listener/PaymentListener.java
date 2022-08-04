package com.system.store.service.listener;

import com.system.store.service.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Log4j2
@Component
public class PaymentListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment){
        log.info("Received the payment {} ", payment.toString());
        sleep(2000);
        log.info("Validating fraud...");
        sleep(2000);
        log.info("Purchase approved...");
        sleep(2000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment){
        sleep(3000);
        log.info("Creating a pdf of the product id {}", payment.getProductId() );
        sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail(@Payload Payment payment){
        log.info("Sending a email to user id {}", payment.getUserId());
        sleep(2000);
    }

}
