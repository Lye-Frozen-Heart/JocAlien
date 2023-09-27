package com.example.jocconversacionalalien.classes;

public abstract class Character {
    private boolean alive = true;
    private Item[] inventario = null;
    private int zoneId;
    protected abstract void ToTake();
    protected abstract void GoTo();
}
