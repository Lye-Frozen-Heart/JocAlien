package com.example.jocconversacionalalien.classes;

public class Zone {
  private int idZone;
  private boolean hasItem;
  private Item[] items = null;
  private boolean hasNpc;
  private boolean hasLight;
  private boolean[] doors = { false, false, false, false };
  private int[] directions = {-1,-1,-1,-1};
  private boolean accessible;
  private boolean hasTraps;

  private void zoneDescription() {}

  private void openDoor() {}

  private void killPlayer() {}

  protected void useItem() {}

  public int getIdZone() {
    return idZone;
  }

  public void setIdZone(int idZone) {
    this.idZone = idZone;
  }

  public boolean isHasItem() {
    return hasItem;
  }

  public void setHasItem(boolean hasItem) {
    this.hasItem = hasItem;
  }

  public Item[] getItems() {
    return items;
  }

  public void setItems(Item[] items) {
    this.items = items;
  }

  public boolean isHasNpc() {
    return hasNpc;
  }

  public void setHasNpc(boolean hasNpc) {
    this.hasNpc = hasNpc;
  }

  public boolean isHasLight() {
    return hasLight;
  }

  public void setHasLight(boolean hasLight) {
    this.hasLight = hasLight;
  }

  public boolean[] getDoors() {
    return doors;
  }

  public void setDoors(boolean[] doors) {
    this.doors = doors;
  }

  public int[] getDirections() {
    return directions;
  }

  public void setDirections(int[] directions) {
    this.directions = directions;
  }

  public boolean isAccessible() {
    return accessible;
  }

  public void setAccessible(boolean accessible) {
    this.accessible = accessible;
  }

  public boolean isHasTraps() {
    return hasTraps;
  }

  public void setHasTraps(boolean hasTraps) {
    this.hasTraps = hasTraps;
  }
}
