package com.kafka.kafkabasics.service;

import com.kafka.kafkabasics.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
  private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

//  @KafkaListener(topics = "user")
//  public void consume(Message message) {
//    logger.info(String.format("$$ -> Consumed Message -> %s", message));
//  }
}
