package com.kafka.kafkabasics.serdes;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class WordCountSerde implements Serde<Object> {

  private WordCountSerializer wordCountSerializer;
  private WordCountDeserializer wordCountDeserializer;

  @Override
  public void configure(Map<String, ?> map, boolean b) {

  }

  @Override
  public void close() {
    wordCountSerializer.close();
    wordCountDeserializer.close();
  }

  @Override
  public Serializer<Object> serializer() {
    return wordCountSerializer;
  }

  @Override
  public Deserializer<Object> deserializer() {
    return wordCountDeserializer;
  }
}
