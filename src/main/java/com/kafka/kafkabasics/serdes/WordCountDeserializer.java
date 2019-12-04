package com.kafka.kafkabasics.serdes;

import com.google.gson.Gson;
import com.kafka.kafkabasics.model.WordCount;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.Charset;
import java.util.Map;

public class WordCountDeserializer implements Deserializer {
  private static final Charset CHARSET = Charset.forName("UTF-8");
  static private Gson gson;

  static {
    gson = new Gson();
  }

  @Override
  public void configure(Map map, boolean b) {

  }

  @Override
  public Object deserialize(String s, byte[] bytes) {
    try {
      // Transform the bytes to String
      String wordCount = new String(bytes, CHARSET);
      // Return the WordCount object created from the String 'wordCount'
      return gson.fromJson(wordCount, WordCount.class);
    } catch (Exception e) {
      throw new IllegalArgumentException("Error reading bytes!", e);
    }
  }

  @Override
  public void close() {

  }
}
