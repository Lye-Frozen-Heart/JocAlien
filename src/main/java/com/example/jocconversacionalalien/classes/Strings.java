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
                "What do you want to do? \n1 - Speak with iHall , \n2 - Look for doors, \n3 - Look for items, \n4 - Open Backpack, \n5 - Move to another room, \n6 - Exit Game"
        );
    }

    public static void MenuIHall() {
        ColorChanger.printTextToBlue(
                "Hi i'm IHall what do you need? \n1 - Flashlight location, \n2 - Alien location, \n3 - Open door, \n4 - What to do, \n5 - Sorry my bad i didnt what to speak with you"
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
        ColorChanger.printTextToGreen("- - - >");
    }


    //Interaction Strings
    public static void IHallFlashlightLocation(String flashlightLocation) {
        System.out.println("The Flashlight is located at: " + flashlightLocation);
    }

    public static void IHallHelp() {
        NotImplemented();
    }

    public static void IHallExit() {
        NotImplemented();
    }


    public static void GameIntroduction() {
        WordElapser.writeWordWithTimeDelay(
                "It's the year 2120 D.C. The spaceship P.A.I XXII explores the empty void of space. It's destination... The planet SM-2523G where it's" +
                        "believed to be the appropriate environment to root another human life colony.We can't stay longer freely on Earth so it is necessary to explore other planets." +
                        "\nThe chief of the ship awakes from the inducted sleep. The main computer of the ship, Halley, has detected one anomaly inside the ship so it does need the Captain intervention" +
                        "\nHalley: How did you sleep Captain? Sadly I have to get you up from your sleep...But I detected an anomaly inside the ship." +
                        "\nCaptain: *sighs* I hope it was worth it for you to awake me...Or you will need an intensive reprogramming session." +
                        "\nHalley: I guarantee you Captain, it's not a false alarm. I can't risk to be punished like that." +
                        "\nCaptain: Okay Halley, explain to me the situation as fast as you can please. I want to take my sleep again." +
                        "\n<*>Halley proceeds to explain the status of the ship, seems like a little meteor hit one side of the complex. The system" +
                        " needs a repair because the propulsion engine has been damaged.",
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
}
