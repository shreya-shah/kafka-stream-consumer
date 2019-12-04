package com.kafka.kafkabasics.message;

public class Message {
  private int id;
  private String message;

  public Message() {
  }

  public Message(int id, String message) {
    this.id = id;
    this.message = message;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "Message{" +
            "id=" + id +
            ", message='" + message + '\'' +
            '}';
  }
}
