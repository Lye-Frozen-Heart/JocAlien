package com.example.jocconversacionalalien.classes;

public class Enemy extends Character{
    public int getIdZone() {
        return idZone;
    }

    public void setIdZone(int idZone) {
        this.idZone = idZone;
    }

    private int idZone;
    private boolean asleep = false;
    @Override
    protected void ToTake() {}
   
    private void pairShift(int shiftCount){
        if(shiftCount % 2 == 0 && !asleep) double rand = Math.random(); setIdZone();
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
