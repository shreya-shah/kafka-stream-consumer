package com.kafka.kafkabasics.config;

import com.kafka.kafkabasics.model.Processor;
import com.kafka.kafkabasics.serdes.WordCountSerde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class KafkaConfig {
  @Autowired
  KafkaProperties kafkaProperties;

//  @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
  @Bean
  public KafkaStreamsConfiguration kStreamsConfigs() {
    Map<String, Object> config = new HashMap<>();
    config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
    config.put(StreamsConfig.APPLICATION_ID_CONFIG, "app-2");
    config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, WordCountSerde.class);
    config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, WordCountSerde.class);
    return new KafkaStreamsConfiguration(config);
  }

//  @Bean
//  public KStream<String, Long> kStream(StreamsBuilder kStreamBuilder) {
//    KStream<String, Long> stream = kStreamBuilder.stream(Processor.INPUT);
//    stream.filter((k, v) -> v % 2 == 0)
//            .mapValues(v -> {
//              System.out.println("Processing :: " + v);
//              return v * v;
//            })
//            .to("output");
//    return stream;
//  }

  @Bean
  public StreamsBuilderFactoryBean kStreamBuilder() {
    return new StreamsBuilderFactoryBean(kStreamsConfigs());
  }

}
