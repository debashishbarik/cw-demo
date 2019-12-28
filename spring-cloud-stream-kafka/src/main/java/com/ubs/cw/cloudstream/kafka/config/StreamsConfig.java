package com.ubs.cw.cloudstream.kafka.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.ubs.cw.cloudstream.kafka.stream.GreetingsStreams;

/**
 * The Class StreamsConfig. Binding the streams is done using the @EnableBinding
 * annotation where the GreatingsService interface is passed to.
 */
@EnableBinding(GreetingsStreams.class)
public class StreamsConfig {

}
