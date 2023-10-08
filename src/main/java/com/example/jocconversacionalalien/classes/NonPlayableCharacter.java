package com.example.jocconversacionalalien.classes;

public class NonPlayableCharacter extends Character{
    boolean asleep = true;
    @Override
    protected void GoTo(int imputDirection,boolean[] doors, int[] directions, int[]availableZones){}
    @Override
    protected void ToTake(){}
    @Override
    protected void CheckZone(int idZone) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CheckZone'");
    }
}