package com.example.jocconversacionalalien.classes;

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
                "What do you want to do? \n1 - Speak with iHall \n2 - Look for doors \n3 - Look for items \n4 - Open Backpack \n5 - Move to another room\n6 - Open map \n7 - Exit Game"
        );
    }

    public static void MenuItemSelection() {
        ColorChanger.printTextToBlue(
                "Select the item you want to look closer or pres 0 to EXIT "
        );
    }

    public static void MenuPickUpItem() {
        ColorChanger.printTextToBlue(
                "Select the item you want to pick up "
        );
    }

    public static void MenuBackpack() {
        ColorChanger.printTextToBlue(
                "what do you want to do? \n1 - Watch item closely \n2 - use item \n3 - drop item \n4 - Exit Backpack"
        );
    }

    public static void menuIHall() {
        ColorChanger.printTextToBlue(
                "Hi i'm IHall what do you need? " +
                        "\n1 - What to do " +
                        "\n2 - Open door " +
                        "\n3 - Exit"
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

    public static void menuHelpIhall(boolean openDoorsAsked) {
        if (!openDoorsAsked) {
            ColorChanger.printTextToBlue("What do you need help for?" +
                    "\n1 - I dont know what i have to do" +
                    "\n2 - Where is the flashlight?" +
                    "\n3 - Where is the alien?" +
                    "\n4 - Where is my companion" +
                    "\n5 - How can i open doors?" +
                    "\n7 - Exit");
        } else {
            ColorChanger.printTextToBlue("What do you need help for?" +
                    "\n1 - I dont know what i have to do" +
                    "\n2 - Where is the flashlight?" +
                    "\n3 - Where is the alien?" +
                    "\n4 - Where is my companion" +
                    "\n5 - How can i open doors?" +
                    "\n6 - Where can i find my Card?" +
                    "\n7 - Exit");
        }
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
    public static void noLight(Item[] items){
        ColorChanger.printTextToRed("Tere is no light in this room, you cant see anything.");
        if(items[3].getOwner()==1) {
            ColorChanger.printTextToRed("It might be useful to turn on the flashlight");
        }else{
            ColorChanger.printTextToRed("A flashlight might be useful here");
        }
    }

    public static void ItemDropped(String playerLocation) {
        System.out.println("Item Dropped at " + playerLocation);
    }

    public static void UseCard() {
        System.out.println("You can ask IHall to open doors with it");
    }

    public static void EatDonut() {
        ColorChanger.printTextToGreen("you just eat the donut, it calms your appetite");
    }

    public static void NoInteracton() {
        System.out.println("You can't use this item now");
    }

    public static void IncorrectCard() {
        ColorChanger.printTextToRed("you need a diferent card to open this door. \n Someone in the ship might have it");
    }

    public static void IHallHelp() {
        ColorChanger.printTextToGreen("you might be able to fix the ship using the tools from the Workshop");
    }

    public static void IHallExit() {
        WordElapser.writeWordWithTimeDelay("Closing menu...", timeToWrite);
    }


    public static void gameIntroduction() {
        WordElapser.writeWordWithTimeDelay(
                """
                        It's the year 2120 D.C. The spaceship P.A.I XXII explores the empty void of space. It's destination... The planet SM-2523G where it's believed to be the appropriate environment to root another human life colony.We can't stay longer freely on Earth so it is necessary to explore other planets.
                        The chief of the ship awakes from the inducted sleep. The main computer of the ship, iHall, has detected one anomaly inside the ship so it does need the Captain intervention
                        iHall: How did you sleep Captain? Sadly I have to get you up from your sleep...But I detected an anomaly inside the ship.
                        Captain: *sighs* I hope it was worth it for you to awake me...Or you will need an intensive reprogramming session.
                        iHall: I guarantee you Captain, it's not a false alarm. I can't risk to be punished like that.
                        Captain: Okay iHall, explain to me the situation as fast as you can please. I want to take my sleep again.
                        <*>iHall proceeds to explain the status of the ship, seems like a little meteor hit one side of the complex. The system needs a repair because the propulsion engine has been damaged.""",
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

    public static void PrintMap() {
        ColorChanger.printTextToGreen(

                "\n" +
                        "                 |||||||||||||||||||||||||||||||" +
                        "\n                 ||                           ||" +
                        "\n                 ||           WORKSHOP        ||" +
                        "\n                 ||                           ||" +
                        "\n |||||||||||||||||||||                     |||||||||||||||||||||||||" +
                        "\n ||                  |                     |                      ||" +
                        "\n ||    DRESSER                OFFICES               BATHROOM      ||" +
                        "\n ||                  |                     |                      ||" +
                        "\n ||||||||     ||||||||||||||||      ||||||||||||||||      ||||||||||" +
                        "\n ||||||||     ||||||||      MACHINE        |||||||||      ||||||||||" +
                        "\n ||||||||     ||||||||       ROOM          |||||||||      ||||||||||" +
                        "\n ||||||||     ||||||||                     |||||||||      ||||||||||" +
                        "\n ||||||||     ||||||||||||||||||||||||||||||||||||||      ||||||||||" +
                        "\n ||                  |                     |                      ||" +
                        "\n ||     KITCHEN               DINNING            BEDROOM          ||" +
                        "\n ||                  |         ROOM        |                      ||" +
                        "\n |||||||||||||||||||||||||||||    ||||||||||||||||||||||||||||||||||" +
                        "\n                              EXIT"
        );

    }

    public static void EndGame() {
        ColorChanger.printTextToRed("End Game");
    }

    public static void NpcIsHere() {
        ColorChanger.printTextToGreen("There is someone else in this room");
    }

    public static void WhereIsAlien(String text) {
        ColorChanger.printTextToBlue("The alien is located in: " + text);
    }

    public static void WhereIsNpc(String text) {
        ColorChanger.printTextToBlue("Your companion is located in: " + text);
    }


    public static void RandomFact() {
        int randomFact = (int) (Math.random() * 5) + 1;
        switch (randomFact) {
            case 0:
                WordElapser.writeWordWithTimeDelay("Did you know?\nHoney never spoils.\n" +
                        " Archaeologists have found pots of honey in ancient Egyptian tombs\n that are over 3,000 years old and still perfectly edible. ", timeToWrite);
                break;
            case 1:
                WordElapser.writeWordWithTimeDelay("Did you know?\nThe shortest war in history took place between Britain and Zanzibar on August 27, 1896.\n" +
                        " It lasted just 38 minutes.", timeToWrite);
                break;
            case 2:
                WordElapser.writeWordWithTimeDelay("Did you know?\nOctopuses have three hearts. Two pump blood to the gills,\n" +
                        "while the third pumps it to the rest of the body.", timeToWrite);
                break;
            case 3:
                WordElapser.writeWordWithTimeDelay("Did you know?\nThe Eiffel Tower can be 15 cm taller during the summer\ndue to the expansion of the iron in the heat.", timeToWrite);
                break;
            case 4:
                WordElapser.writeWordWithTimeDelay("Did you know?\nThe unicorn is Scotland's national animal.", timeToWrite);
                break;
            case 5:
                WordElapser.writeWordWithTimeDelay("Did you know?\nBananas are berries, but strawberries are not.\nIn botanical terms," +
                        " a berry is a fruit produced from the ovary of a single flower\nwith seeds embedded in the flesh. ", timeToWrite);
                break;
        }
    }

    public static void EmptyInventory() {
        ColorChanger.printTextToGreen("You have nothing in your inventory");
    }

    // ALIEN INTERACTION STRINGS
    public static void Infected() {
        ColorChanger.printTextToRed("It seems like the alien has laid eggs in you... your belly splits open and something comes out of it. ");
    }

    public static void AlienIsHere() {
        ColorChanger.printTextToRed("You feel chills down your spine. Something dangerous is here... \n you must act quickly");
    }

    public static void NoThreat() {
        ColorChanger.printTextToBlue("it seems that the Alien is falling sleep for ever, is not longer a threat");
    }

    public static void AlienEatDonut() {
        ColorChanger.printTextToBlue("you give the alien a little treat, he eats the donut and it seems that's acting like a sleeping pill");
    }

    public static void AlienKillsYou() {
        ColorChanger.printTextToRed("as soon as you turn your back, you feel something piercing throw your skin \n you have been killed by the alien");
    }

    //IHall Help
    public static void generalHelp() {
        ColorChanger.printTextToBlue("Something has happened to your ship, you need to scape before it explodes, \ngo to the exit and pick up a scape pod if you want to survive");
    }

    public static void howToOpenDoors() {
        ColorChanger.printTextToBlue("You need to show me your card so i can unlock the doors for you");
    }
    public static void whereIsTheCard() {
        ColorChanger.printTextToBlue("It should be at your desk in the office");
    }

    //NPC Interactions
    public static void askingNpcForTheCard(){
        ColorChanger.printTextToBlue("Your colleague is sitting at the end of the room... \nYou proceed to ask him for his card");
        ColorChanger.printTextToGreen("Hey, do you steel have the card to open the exit door?");
        System.out.println("Yes why do you ask?");
        ColorChanger.printTextToGreen("Can i borrow it?");
        System.out.println("Ye sure, there you have it");
        ColorChanger.printTextToBlue("you acquire the Exit Card");
    }
}
