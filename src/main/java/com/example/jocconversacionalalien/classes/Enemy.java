package com.example.jocconversacionalalien.classes;

public class Enemy extends Character{
    private boolean asleep = true;
    private int shiftCount = 0;
    private int idZone = 3;
   
    private void pairShift(int shiftCount,int imputDirection,boolean[] doors, int[] directions, int[]availableZones){
        if(shiftCount % 2 == 0 && !asleep) GoTo(imputDirection,doors,directions,availableZones);
    }
    @Override
    protected void CheckZone(int idZone) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CheckZone'");
    }
    @Override
    protected void GoTo(int imputDirection, boolean[] doors, int[] directions, int[] availableZones) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'GoTo'");
    }

    public int getIdZone() {
        return idZone;
    }

    public boolean isAsleep() {
        return asleep;
    }

    public void setAsleep(boolean asleep) {
        this.asleep = asleep;
    }
}
