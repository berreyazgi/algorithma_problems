package com.example;

public class Passanger extends Person{
  
  private String ticket;
  private int priority;

  //constructor
  public Passanger(String name, String type, long Id, String ticket, int priority) {
    super(name, "passanger", Id);
    this.ticket = ticket;
    this.priority = priority;
  }
   // Getter for ticket
  public String getTicket() {
    return ticket;
  }
// Setter for ticket
  public void setTicket(String ticket) {
    this.ticket = ticket;
  }

  // Getter for priority
  public int getPriority() {
    return priority;
  }

  // Setter for priority
  public void setPriority(int priority) {
    this.priority = priority;
  }
}
 

