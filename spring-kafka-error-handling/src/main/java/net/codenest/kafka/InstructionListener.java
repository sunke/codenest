package net.codenest.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.TopicSuffixingStrategy;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InstructionListener {

    @RetryableTopic(kafkaTemplate = "kafkaTemplate",
            attempts = "4",
            autoCreateTopics = "false",
            retryTopicSuffix = ".retry",
            topicSuffixingStrategy = TopicSuffixingStrategy.SUFFIX_WITH_INDEX_VALUE,
            dltTopicSuffix = ".dlt",
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

    @DltHandler
    public void dltProcess(String instruction) {
        log.info("Process the dlt instruction {}", instruction);
    }
}
