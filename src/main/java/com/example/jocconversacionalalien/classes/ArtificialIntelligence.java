package com.example.jocconversacionalalien.classes;

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
    public String askForAlien(){
        return "not implemented";
    }

    public String askForFlashlight() {

        int flashlightLocation = gameItems[3].getLocalization();

        if (IsRandom()) {
            int randomZone;
            do {
                randomZone = random.nextInt(8) + 1;
            } while (randomZone == flashlightLocation - 1);
            zone = gameZones[(randomZone)].getName();
        } else {
            zone = gameZones[flashlightLocation - 1].getName();
        }
        return zone;
    }

    public boolean IsRandom(){
        boolean isRandom =true;
        int number =random.nextInt(2) + 1;

        if(number==1){isRandom=false;}


        return isRandom;
    }
}
