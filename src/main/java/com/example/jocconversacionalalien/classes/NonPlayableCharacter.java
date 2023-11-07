package com.example.jocconversacionalalien.classes;

public class NonPlayableCharacter extends Character{
    public boolean isAsleep() {
        return asleep;
    }

    public void setAsleep(boolean asleep) {
        this.asleep = asleep;
    }

    boolean asleep = false;

    public int getIdZone() {
        return idZone;
    }

    public void setIdZone(int idZone) {
        this.idZone = idZone;
    }

    private int idZone;
    @Override
    protected void GoTo(int imputDirection,boolean[] doors, int[] directions, int[]availableZones,Zone currentZone){}

    @Override
    protected void CheckZone(int idZone) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CheckZone'");
    }
    public void fourthShift(int shiftCount){
        //SE UTILIZA PARA MOVER AL NPC
        if(shiftCount % 4 == 0 && !asleep){
            int randomGoneFourth = (int)(Math.random()*4) + 1;
            int randomGonePair = (int)(Math.random()*2) + 1;
            int actZone = getIdZone();
            switch (actZone){
                case ZoneInitializer.WORKSHOP, ZoneInitializer.MACHINE_ROOM -> setIdZone(ZoneInitializer.OFFICES);
                case ZoneInitializer.OFFICES -> {
                    if(randomGoneFourth == 1) setIdZone(ZoneInitializer.WORKSHOP);
                    else if(randomGoneFourth == 2) setIdZone(ZoneInitializer.BATHROOM);
                    else if(randomGoneFourth == 3) setIdZone(ZoneInitializer.LOCKER_ROOM);
                    else if(randomGoneFourth == 4) setIdZone(ZoneInitializer.MACHINE_ROOM);
                }
                case ZoneInitializer.LOCKER_ROOM -> {
                    if(randomGonePair == 1) setIdZone(ZoneInitializer.KITCHEN);
                    else setIdZone(ZoneInitializer.OFFICES);
                }
                case ZoneInitializer.KITCHEN -> {
                    if(randomGonePair == 1) setIdZone(ZoneInitializer.DINNING_ROOM);
                    else setIdZone(ZoneInitializer.LOCKER_ROOM);
                }
                case ZoneInitializer.DINNING_ROOM ->{
                    if(randomGonePair == 1) setIdZone(ZoneInitializer.BEDROOM);
                    else setIdZone(ZoneInitializer.KITCHEN);
                }
                case ZoneInitializer.BEDROOM ->{
                    if(randomGonePair == 1) setIdZone(ZoneInitializer.BATHROOM);
                    else setIdZone(ZoneInitializer.DINNING_ROOM);
                }
                case ZoneInitializer.BATHROOM ->{
                    if(randomGonePair == 1) setIdZone(ZoneInitializer.OFFICES);
                    else setIdZone(ZoneInitializer.BEDROOM);
                }
            }
        }
    }
}