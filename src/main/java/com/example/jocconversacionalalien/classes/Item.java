package com.example.jocconversacionalalien.classes;

public class Item {

  private String name;
  private String description;
  private boolean status;
  private String localization;
  private int owner;

  private void useItem(){}

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public void setLocalization(String localization) {
    this.localization = localization;
  }

  public void setOwner(int owner) {
    this.owner = owner;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public boolean isStatus() {
    return status;
  }

  public String getLocalization() {
    return localization;
  }

  public int getOwner() {
    return owner;
  }
}
