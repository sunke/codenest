package net.codenest.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.converter.MessageConversionException;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InstructionListener {

    @RetryableTopic(kafkaTemplate = "kafkaTemplate",
            attempts = "4",
            backoff = @Backoff(delay = 3000, multiplier = 1.5, maxDelay = 15000)
    )
    @KafkaListener(topics = "instruction", groupId = "stl")
    public void listen(@Header(KafkaHeaders.RECEIVED_TOPIC) String receivedTopic, String instruction) {
        log.info("Topic({}) handler receive data = {}", receivedTopic, instruction);
        try {
           throw new RuntimeException("Some error happens!");
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
            throw e;
        }
    }
}
