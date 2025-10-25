package com.example;

public class Cabin_Crew extends Person {
  private String job;
  private double credit;

  //constructor
  public Cabin_Crew(String name, String type, long Id, String job, double credit) {
    super(name, "cabin-crew", Id);
    this.job = job;
    this.credit = credit;
  }
  // Getter for job
  public String getJob() {
    return job;
  }
  // Setter for job
  public void setJob(String job) {
    this.job = job;
  }
  // Getter for credit
  public double getCredit() {
    return credit;
  }
  // Setter for credit
  public void setCredit(double credit) {
    this.credit = credit;
  }
  
}
