package com.example.jocconversacionalalien.classes;

public abstract class Character {
    private boolean alive = true;
    //Items[] inventario = [6];
    private int zoneId;

    protected abstract void ToTake();
    protected abstract void GoTo();
}
