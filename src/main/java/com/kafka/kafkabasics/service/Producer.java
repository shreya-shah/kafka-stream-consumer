package com.kafka.kafkabasics.service;

import com.kafka.kafkabasics.message.Message;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Properties;
import java.util.regex.Pattern;

@Service
public class Producer {
  private static final Logger logger = LoggerFactory.getLogger(Producer.class);
  private static final String TOPIC = "inputStream";

  @Autowired
  KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(Message message) {
    logger.info(String.format("$$ --> Producing message --> %s", message));
//    this.kafkaTemplate.send(TOPIC, message);
  }

  public void sendMessage(String message) {
    logger.info(String.format("$$ --> Producing message --> %s", message));
    this.kafkaTemplate.send(TOPIC, message);
  }
}
