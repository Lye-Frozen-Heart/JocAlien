package com.example.jocconversacionalalien.classes;

public class Zone {
  private int idZone;
  private boolean hasItem;
  private Item[] items = null;
  private boolean hasNpc;
  private boolean hasLight;
  private boolean[] doors = { false, false, false, false };
  private boolean accessible;
  private boolean hasTraps;

  private void zoneDescription() {}

  private void openDoor() {}

  private void killPlayer() {}

  protected void useItem() {}
}
