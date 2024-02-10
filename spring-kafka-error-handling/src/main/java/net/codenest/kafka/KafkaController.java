package net.codenest.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private InstructionPublisher publisher;

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        publisher.sendInstruction("instruction", message);
        return "Message sent: " + message;
    }

}