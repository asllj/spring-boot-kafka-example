package com.example.demoproducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private final Logger logger = LoggerFactory.getLogger(ProducerController.class);


    @Autowired
    private KafkaTemplate<Object,Object> template;

    @PostMapping(path = "/send/topic1/{message}")
    public void sendMessageTopic1(@PathVariable String message) {
        logger.info("Sending message for topic 1.....");
        for(int i = 0; i<10;i++){
            this.template.send("topic1", message + i);
        }

    }

    @PostMapping(path = "/send/topic2/{message}")
    public void sendMessageTopic2(@PathVariable String message) {
        logger.info("Sending message for topic 2.....");
        this.template.send("topic2", message);
    }

    @PostMapping(path = "/send/topic3/{message}")
    public void sendMessageTopic3(@PathVariable String message) {
        logger.info("Sending message for topic 3.....");
        this.template.send("topic3", message);
    }
}
