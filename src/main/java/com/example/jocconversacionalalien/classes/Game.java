package com.example.jocconversacionalalien.classes;

import java.util.Scanner;

public class Game {

  //CONSTANTS FOR ROOM ID
  private static final int timeToWrite = 0;

  private int countTurn;

  static boolean validAnswer = false;
  static Zone[] zones = {};
  static Player player = new Player();

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
        WordElapser.writeWordWithTimeDelay("Genial comenzaste", timeToWrite);
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
        break;
      case 3:
        exitGame();
        break;
    }
  }

  private static  void startGame() {
    final int LOOK_AROUD = 1;
    final int CHECK_DOORS = 2;
    final int MOVE = 3;
    final int EXIT_GAME = 4;

    int options = 0;
    zones=ZoneInitializer.setUpZones();
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
        System.out.println(
          "whats do you want to do? 1- look around, 2-check doors, 3-move, 4-exit game"
        );
        if (scanner.hasNextInt()) {
          options = scanner.nextInt();
          validAnswer = true;
        } else {
          System.out.println("thats not an option");
        }
      } while (!validAnswer);

      switch (options) {
        case LOOK_AROUD:
          zones[player.getIdZone()-1].getDescriptionZone();
          break;
        case CHECK_DOORS:
          player.LookAround(zones[player.getIdZone()-1].getAvailableZones());
          break;
        case MOVE:
          movement();
          break;
        case EXIT_GAME:
          exitGame();
          break;
        default:
          System.out.println("not a valid option");
      }
    } while (options != EXIT_GAME);
  }

  private static void movement() {
    validAnswer = false;
    Scanner scanner = new Scanner(System.in);
    do {
      System.out.println(
        "where doy you want to move? 1-north, 2-east, 3-south, 4-west"
      );
      if (scanner.hasNextInt()) {
        int selected = scanner.nextInt() - 1;
        if (selected < 0 || selected > 3) {
          System.out.println("thats not a option");
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
        System.out.println("thats not an option");
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
