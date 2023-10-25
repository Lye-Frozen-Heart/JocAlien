package com.example.jocconversacionalalien.classes;

import static com.example.jocconversacionalalien.classes.ItemInitializer.random;

public class Strings {
    private static final int timeToWrite = 0;

    //Error Strings
    public static void InputError() {
        System.out.println("That's not an option");
    }

    public static void NotImplemented() {
        System.out.println("Not implemented");
    }


    //Menu Strings
    public static void MenuLightOnOptions() {
        ColorChanger.printTextToBlue(
                "What do you want to do? \n1 - Speak with iHall , \n2 - Look for doors, \n3 - Look for items, \n4 - Open Backpack, \n5 - Move to another room, \n6 - Exit Game"
        );
    }
    public static void MenuItemSelection() {
        ColorChanger.printTextToBlue(
                "Select the item you want to look closer or pres 0 to EXIT "
        );
    }
    public static void MenuBackpack() {
        ColorChanger.printTextToBlue(
                "what do you want to do? \n1 - Watch item closely \n2 - use item \n3 - drop item \n4 - Exit Backpack"
        );
    }

    public static void MenuIHall() {
        ColorChanger.printTextToBlue(
                "Hi i'm IHall what do you need? \n1 - Flashlight location \n2 - Alien location \n3 - Open door \n4 - What to do \n5 - Companion location \n6 - Sorry my bad i didnt what to speak with you"
        );
    }

    public static void MenuOpenDoor() {
        ColorChanger.printTextToBlue(
                "Which door do you want to open?" +
                        "\n 1 - North, 2 - East, 3 - South, 4 - West"
        );
    }

    public static void MenuMovement() {
        ColorChanger.printTextToBlue(
                "Where do you want to move?" +
                        "\n 1 - North, 2 - East, 3 - South, 4 - West"
        );
    }

    public static void MenuInitGame() {
        WordElapser.writeWordWithTimeDelay(
                "Good to see you again Captain, have you slept well? Select a menu option:",
                timeToWrite
        );
        ColorChanger.printTextToGreen(
                "_|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|\n" +
                        "___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|__"
        );
        ColorChanger.printTextToBlue("- NEW GAME --> 1");
        ColorChanger.printTextToGreen("- CREDITS --> 2");
        ColorChanger.printTextToRed("- EXIT GAME --> 3");


        ColorChanger.printTextToGreen(
                "_|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|"
        );
        ColorChanger.printTextToGreen("Introduce an option: ⇣");
    }


    //Interaction Strings
    public static void IHallFlashlightLocation(String flashlightLocation) {
        System.out.println("The Flashlight is located at: " + flashlightLocation);
    }
    public static void ItemDropped(String playerLocation) {
        System.out.println("Item Dropped at " + playerLocation);
    }
    public static void UseCard( ) {
        System.out.println("You can ask IHall to open doors with it");
    }
    public static void NoInteracton( ) {
        System.out.println("You can't use this item now");
    }

    public static void IHallHelp() {
        NotImplemented();
    }

    public static void IHallExit() {
        WordElapser.writeWordWithTimeDelay("Closing menu...",timeToWrite);
    }


    public static void GameIntroduction() {
        WordElapser.writeWordWithTimeDelay(
                """
                        It's the year 2120 D.C. The spaceship P.A.I XXII explores the empty void of space. It's destination... The planet SM-2523G where it's believed to be the appropriate environment to root another human life colony.We can't stay longer freely on Earth so it is necessary to explore other planets.
                        The chief of the ship awakes from the inducted sleep. The main computer of the ship, Halley, has detected one anomaly inside the ship so it does need the Captain intervention
                        Halley: How did you sleep Captain? Sadly I have to get you up from your sleep...But I detected an anomaly inside the ship.
                        Captain: *sighs* I hope it was worth it for you to awake me...Or you will need an intensive reprogramming session.
                        Halley: I guarantee you Captain, it's not a false alarm. I can't risk to be punished like that.
                        Captain: Okay Halley, explain to me the situation as fast as you can please. I want to take my sleep again.
                        <*>Halley proceeds to explain the status of the ship, seems like a little meteor hit one side of the complex. The system needs a repair because the propulsion engine has been damaged.""",
                timeToWrite
        );
    }
    public static void Credits() {
        ColorChanger.printTextToGreen("/--//--//--//--//--//--//--//--//--/");
        WordElapser.writeWordWithTimeDelay(
                "This game has been developed by Alexandre Torres Bravo and Sergi Andreu Vila",
                timeToWrite
        );
        ColorChanger.printTextToGreen("/--//--//--//--//--//--//--//--//--/");
        ColorChanger.printTextToBlack("© All rights to be reserved...");
    }
    public static void AlienIsHere(){
        ColorChanger.printTextToRed("You feel chills down your spine. Something dangerous is here...");
    }
    public static void NpcIsHere(){
        ColorChanger.printTextToGreen("Tu compañero está en la sala ve a decirle hola!");
    }
    public static void WhereIsAlien(String text){
        ColorChanger.printTextToBlue("The alien is located in: " + text);
    }
    public static void WhereIsNpc(String text){ColorChanger.printTextToBlue("Your companion is located in: " + text);}

    public static void RandomFact(){
       int randomFact = (int)(Math.random()*5)+1;
       switch (randomFact){
           case 0:
           WordElapser.writeWordWithTimeDelay("Did you know?\nHoney never spoils.\n" +
           " Archaeologists have found pots of honey in ancient Egyptian tombs\n that are over 3,000 years old and still perfectly edible. ",timeToWrite);
           break;
           case 1:
           WordElapser.writeWordWithTimeDelay("Did you know?\nThe shortest war in history took place between Britain and Zanzibar on August 27, 1896.\n" +
           " It lasted just 38 minutes.",timeToWrite);
           break;
           case 2:
           WordElapser.writeWordWithTimeDelay("Did you know?\nOctopuses have three hearts. Two pump blood to the gills,\n" +
           "while the third pumps it to the rest of the body.",timeToWrite);
           break;
           case 3:
           WordElapser.writeWordWithTimeDelay("Did you know?\nThe Eiffel Tower can be 15 cm taller during the summer\ndue to the expansion of the iron in the heat.",timeToWrite);
           break;
           case 4:
           WordElapser.writeWordWithTimeDelay("Did you know?\nThe unicorn is Scotland's national animal.",timeToWrite);
           break;
           case 5:
           WordElapser.writeWordWithTimeDelay("Did you know?\nBananas are berries, but strawberries are not.\nIn botanical terms," +
           " a berry is a fruit produced from the ovary of a single flower\nwith seeds embedded in the flesh. ",timeToWrite);
           break;
       }
    }
    public static void EmptyInventory(){
        ColorChanger.printTextToGreen("You have nothing in your inventory");
    }
}
