package com.SWEasabi.mqttdemo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
class Lamp {

  private @Id @GeneratedValue Long id;
  private String status;
  private String location;

  Lamp() {}

  Lamp(String status, String location) {

    this.status = status;
    this.location = location;
  }

  public Long getId() {
    return this.id;
  }

  public String getStatus() {
    return this.status;
  }

  public String getLocation() {
    return this.location;
  }
  
  public void setId(Long id)
  {
	  this.id=id;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Lamp))
      return false;
    Lamp lamp = (Lamp) o;
    return Objects.equals(this.id, lamp.id) && Objects.equals(this.status, lamp.status)
        && Objects.equals(this.location, lamp.location);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.status, this.location);
  }

  @Override
  public String toString() {
    return "Lamp{" + "id=" + this.id + ", status='" + this.status + '\'' + ", role='" + this.location + '\'' + '}';
  }
}