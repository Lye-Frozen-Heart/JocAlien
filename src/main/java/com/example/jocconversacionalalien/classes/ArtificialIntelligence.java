package com.example.jocconversacionalalien.classes;

import java.util.Arrays;
import java.util.stream.Stream;

import static com.example.jocconversacionalalien.classes.ItemInitializer.random;

public class ArtificialIntelligence {
    private boolean angry = false;
    private int randomQuestion ;
    static Item[] gameItems = ItemInitializer.setUpItems();
    static Zone[] gameZones = ZoneInitializer.setUpZones();
    String zone;

    private void sayTruth() {
    }

    private void sayALie() {
    }

    private void openDoors() {
    }

    private void makeLifeImpossible() {
    }
    public void askForAlien(Zone[] zones,Enemy alien){
        Stream<Zone> zonaAlien = Arrays.stream(zones).filter(filter -> filter.getIdZone() == alien.getIdZone());
        if(!IsRandom()) zonaAlien.forEach( zona -> Strings.WhereIsAlien(zona.getName())); else Strings.RandomFact();
    }
    public void askForNpc(Zone[] zones,NonPlayableCharacter npc){
        Stream<Zone> zonaNpc = Arrays.stream(zones).filter(filter -> filter.getIdZone() == npc.getIdZone());
        if(!IsRandom()) zonaNpc.forEach( zona -> Strings.WhereIsNpc(zona.getName())); else Strings.RandomFact();
    }

    public String askForFlashlight() {

        int flashlightLocation = gameItems[3].getLocalization();

        if (IsRandom()) {
            int randomZone;
            do {
                randomZone = random.nextInt(9) + 1;
            } while (randomZone == flashlightLocation - 1);

            zone = gameZones[(randomZone)].getName();

            return zone;

        } else {
            zone = gameZones[flashlightLocation - 1].getName();
            return zone;
        }
    }

    public boolean IsRandom(){
        boolean isRandom =true;
        int number =random.nextInt(2) + 1;

        if(number==1){isRandom=false;}


        return isRandom;
    }
}
