package com.kafka.kafkabasics.model;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Sink {
  String INPUT = "output";

  @Input(Sink.INPUT)
  KStream<String, WordCount> inputStream();
}
