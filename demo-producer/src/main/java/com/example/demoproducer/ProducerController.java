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

    @PostMapping(path = "/send/foo/{message}")
    public void sendFoo(@PathVariable String message) {
        logger.info("Sending message.....");
        this.template.send("topic1", message);
    }
}
