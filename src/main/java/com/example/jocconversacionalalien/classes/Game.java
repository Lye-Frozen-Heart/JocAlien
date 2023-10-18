package com.example.jocconversacionalalien.classes;

import java.util.Scanner;

public class Game {

    //CONSTANTS FOR ROOM ID
    private static final int timeToWrite = 0;
    private static int countTurn = 0;
    static boolean validAnswer = false;
    static Zone[] zones = {};
    static Item[] items = {};
    static Player player = new Player();
    static Enemy alien = new Enemy();
    static NonPlayableCharacter npc = new NonPlayableCharacter();
  private static void menu() {
    Scanner scanner = new Scanner(System.in);
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
    int selected = scanner.nextInt();
    switch (selected) {
      case 1:
        startGame();
        break;
      case 2:
        ColorChanger.printTextToGreen("/--//--//--//--//--//--//--//--//--/");
        WordElapser.writeWordWithTimeDelay(
          "This game has been developed by Alexandre Torres Bravo and Sergi Andreu Vila",
          timeToWrite
        );
        ColorChanger.printTextToGreen("/--//--//--//--//--//--//--//--//--/");
        ColorChanger.printTextToBlack("© All rights to be reserved...");
        menu();
        break;
      case 3:
        exitGame();
        break;
    }
  }

    private static void startGame() {

        //constants
        final int LOOK_AROUD = 1;
        final int CHECK_DOORS = 2;
        final int MOVE = 3;
        final int OPEN_DOOR = 4;
        final int EXIT_GAME = 5;

        //variables
        int options = 0;

        //initialize
        zones = ZoneInitializer.setUpZones();
        items = ItemInitializer.setUpItems();


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
        Scanner scanner = new Scanner(System.in);
        do {
            do {
                validAnswer = false;
                ColorChanger.printTextToBlue(
                        "What do you want to do? 1 - Look around, 2 - Check doors, 3 - Move, 4 - Open Door, 5 - Exit game"
                );
                if (scanner.hasNextInt()) {
                    options = scanner.nextInt();
                    setCountTurn(countTurn++);
                    validAnswer = true;
                } else {
                    ColorChanger.printTextToRed("That's not an option");
                }
                if(alien.pairShift(countTurn,))
                //If( player.id  === alien.id )

            } while (!validAnswer);

            switch (options) {
                case LOOK_AROUD:
                    zones[player.getIdZone() - 1].getDescriptionZone();
                    break;
                case CHECK_DOORS:
                    player.LookAround(zones[player.getIdZone() - 1].getAvailableZones());
                    break;
                case MOVE:
                    movement();
                    break;
                case OPEN_DOOR:
                    do {
                        validAnswer = false;
                        ColorChanger.printTextToBlue(
                                "Which door do you want to open?" +
                                        "\n 1 - North, 2 - East, 3 - South, 4 - West"
                        );
                        if (scanner.hasNextInt()) {
                            int direction = scanner.nextInt();
                            if (direction > 0 && direction < 5) {
                                validAnswer = true;
                                player.ToOpen(items, zones, player.getIdZone()-1, direction - 1);
                            } else {
                                System.out.println("That's not an option");
                            }
                        } else {
                            System.out.println("That's not an option");
                        }
                    } while (!validAnswer);

                    break;
                case EXIT_GAME:
                    exitGame();
                    break;
                default:
                    System.out.println("Not a valid option");
            }
        } while (options != EXIT_GAME);
    }

  private static void movement() {
    validAnswer = false;
    Scanner scanner = new Scanner(System.in);
    do {
      ColorChanger.printTextToBlue(
        "Where do you want to move?" +
             "\n 1 - North, 2 - East, 3 - South, 4 - West"
      );
      if (scanner.hasNextInt()) {
        int selected = scanner.nextInt() - 1;
        if (selected < 0 || selected > 3) {
          System.out.println("That's not a option");
        } else {
          player.GoTo(
            selected,
            zones[player.getIdZone()-1].getDoors(),
            zones[player.getIdZone()-1].getDirections(),
            zones[player.getIdZone()-1].getAvailableZones()
          );
          validAnswer = true;
        }
      } else {
        System.out.println("That's not an option");
      }
    } while (!validAnswer);
  }

  private void pauseGame() {
    //TODO
  }

  private void restartGame() {
    //TODO
  }

  private static void exitGame() {
    System.exit(0);
  }
    public static int getCountTurn() {
        return countTurn;
    }

    public static void setCountTurn(int countTurn) {
        Game.countTurn = countTurn;
    }

  //TODO                        /////////////////////////////////
  //TODO                       //            TALLERES          //
  //TODO         /////////////////////                      ///////////////////////
  //TODO         ||                  |                      |                     ||
  //TODO         ||    VESTUARIO              OFICINAS               BAÑOS         ||
  //TODO         ||                  |                     |                      ||
  //TODO         ||/////      //////////////      /////////////////       ////////||
  //TODO         ||                  |      MÁQUINAS       |                      ||
  //TODO         ||                  |                     |                      ||
  //TODO         ||////        /////////////////////////////////////     /////////||
  //TODO         ||                  |                     |                      ||
  //TODO         ||     COCINA            COMEDOR                DORMITORIO       ||
  //TODO         ||                  |                     |                      ||
  //TODO        /////////////////////////////    /////////////////////////////////||
  //TODO                                    SALIDA


    public static void main(String[] args) {
        menu();
    }
}
