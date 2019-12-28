package com.ubs.cw.cloudstream.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import lombok.extern.slf4j.Slf4j;

/**
 * The Class SpringCloudStreamKafkaApplication.
 * https://dzone.com/articles/spring-cloud-stream-with-kafka
 */

@SpringBootApplication
@Slf4j
public class SpringCloudStreamKafkaApplication {

	public static void main(final String[] args) {
		SpringApplication.run(SpringCloudStreamKafkaApplication.class, args);
	}

}
