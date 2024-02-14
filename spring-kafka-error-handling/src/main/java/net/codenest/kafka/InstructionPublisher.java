package net.codenest.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class InstructionPublisher {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Transactional(transactionManager = "kafkaTransactionManager", rollbackFor = Throwable.class)
    public void sendInstruction(String topic, String instruction) {
        kafkaTemplate.send(topic, instruction);
    }

}
