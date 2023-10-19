package com.example.jocconversacionalalien.classes;

import java.util.ArrayList;

public class Enemy extends Character{
    private int idZone;
    private boolean asleep = false;
    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    private ArrayList<Item> inventory = new ArrayList<Item>();
    @Override
    protected void ToTake() {}
    public int getIdZone() {
        return idZone;
    }

    public void setIdZone(int idZone) {
        this.idZone = idZone;
    }
    public void pairShift(int shiftCount){
        if(shiftCount % 2 == 0 && !asleep){
            int randomZone = (int)(Math.random()*9) + 1; //Este random funciona
            setIdZone(randomZone);
        }
    }
    @Override
    protected void CheckZone(int idZone) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CheckZone'");
    }
    @Override
    protected void GoTo(int inputDirection, boolean[] doors, int[] directions, int[] availableZones) {

    }
}
