package net.codenest.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class InstructionPublisher {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendInstruction(String topic, String instruction) {
        kafkaTemplate.send(topic, instruction);
    }

}
