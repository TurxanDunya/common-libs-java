package com.projecthope.sms.producer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class MsSmsProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSmsProducerApplication.class, args);
	}

	//Notice that depends on your message type, KafkaTemplate map value will be changed prior to it
	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			kafkaTemplate.send("sms", "Hello Kafka!");
		};
	}

}
