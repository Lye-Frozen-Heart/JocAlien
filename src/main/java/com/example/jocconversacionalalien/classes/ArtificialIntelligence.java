package com.example.jocconversacionalalien.classes;

import static com.example.jocconversacionalalien.classes.ItemInitializer.random;

public class ArtificialIntelligence {
    private boolean angry = false;
    private int randomQuestion = (random.nextInt(2) + 1);
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

        if (randomQuestion == 1) {
            zone = gameZones[flashlightLocation - 1].getName();
            return zone;
        } else {
            int randomZone;
            do {
                randomZone = random.nextInt(9) + 1;
            } while (randomZone == flashlightLocation - 1);

            zone = gameZones[(randomZone)].getName();

            return zone;
        }
    }
}
