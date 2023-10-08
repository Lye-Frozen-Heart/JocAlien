package com.example.jocconversacionalalien.classes;

public class Enemy extends Character{
    private boolean asleep = true;
    private int shiftCount = 0;
    @Override
    protected void ToTake() {}
   
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
}
