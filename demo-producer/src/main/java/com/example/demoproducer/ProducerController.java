package com.example.demoproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private KafkaTemplate<Object,Object> template;

    @PostMapping(path = "/send/foo/{message}")
    public void sendFoo(@PathVariable String message) {
        this.template.send("topic1", new Notification(message));
    }
}
