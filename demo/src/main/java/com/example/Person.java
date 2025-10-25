package com.example;

public class Person {
  private String name;
  private String type;
  private long Id;

  public Person(String name, String type, long Id) {
    this.name = name;
    this.type = type;
    this.Id = Id;
  }

  // Getter for name
  public String getName() {
    return name;
  }

  // Setter for name
  public void setName(String name) {
    this.name = name;
  }

  // Getter for type
  public String getType() {
    return type;
  }

  // Setter for type
  public void setType(String type) {
    this.type = type;
  }

  // Getter for ID
  public long getID() {
    return Id;
  }

  // Setter for ID
  public void setID(long ID) {
    this.Id = Id;
  }
}

