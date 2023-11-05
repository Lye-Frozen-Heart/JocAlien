package com.example.jocconversacionalalien.classes;

import java.util.ArrayList;

public class Enemy extends Character{
    private int idZone;
    private boolean asleep = false;
    private boolean knocked = false;
    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    private ArrayList<Item> inventory = new ArrayList<Item>();


    public void setIdZone(int idZone) {
        this.idZone = idZone;
    }
    public void pairShift(int shiftCount){
        //SE UTILIZA PARA MOVER AL ALIEN
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

    public int getIdZone() {
        return idZone;
    }


    public boolean isAsleep() {
        return asleep;
    }

    public boolean isKnocked() {
        return knocked;
    }

    public void setAsleep(boolean asleep) {
        this.asleep = asleep;
    }

    public void setKnocked(boolean knocked) {
        this.knocked = knocked;
    }
}
