package com.workers.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

@Entity
public class Worker {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String firstName;

  private String lastName;

  @Column(unique = true)
  private String workerNumber;

  private Date birthDate;

  private Date startWorkAt;

  @ManyToOne
  private Unit unit;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getWorkerNumber() {
    return workerNumber;
  }

  public void setWorkerNumber(String workerNumber) {
    this.workerNumber = workerNumber;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public Date getStartWorkAt() {
    return startWorkAt;
  }

  public void setStartWorkAt(Date startWorkAt) {
    this.startWorkAt = startWorkAt;
  }

  public Unit getUnit() {
    return unit;
  }

  public void setUnit(Unit unit) {
    this.unit = unit;
  }
}
