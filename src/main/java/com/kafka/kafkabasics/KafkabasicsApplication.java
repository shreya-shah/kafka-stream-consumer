package com.kafka.kafkabasics;

import com.kafka.kafkabasics.model.Processor;
import com.kafka.kafkabasics.model.WordCount;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;


@EnableBinding(Processor.class)
@SpringBootApplication
public class KafkabasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkabasicsApplication.class, args);
	}

	@StreamListener(Processor.INPUT)
	public void process(@Input(Processor.INPUT) KStream<String, WordCount> input) {

		System.out.println("in process of consumer..."+input);

		input.foreach((w,c) -> {
			System.out.println("word: " + w + " -> " + c);
		});
	}

}
