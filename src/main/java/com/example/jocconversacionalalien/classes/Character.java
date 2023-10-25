package com.example.jocconversacionalalien.classes;

public abstract class Character {
    private boolean alive = true;
    private int zoneId;
    protected abstract void GoTo(int imputDirection,boolean[] doors, int[] directions, int[]availableZones);
    protected abstract void CheckZone(int idZone);
}
