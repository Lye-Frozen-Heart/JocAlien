package com.example.jocconversacionalalien.classes;

public class Enemy extends Character{
    private boolean asleep = true;
    private int shiftCount = 0;
    @Override
    protected void ToTake() {}
    @Override
    protected void GoTo() {}
    private void pairShift(int shiftCount){
        if(shiftCount % 2 == 0 && !asleep) GoTo();
    }
}
