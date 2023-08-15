package com.example.democonsumer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class DemoConsumer2Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoConsumer2Application.class, args);
    }


    @KafkaListener(id = "consumer 2", topics = "topic1")
    public void listen(String in) {
        System.out.println("CONSUMING MESSAGE: " + in);
    }

}
