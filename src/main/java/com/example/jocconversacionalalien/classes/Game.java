package com.example.jocconversacionalalien.classes;

import java.util.Scanner;

public class Game {
  private int countTurn;
  Zone[] zones = {};
  private static void menu() {
     final int timeToWrite = 250;
   Scanner scanner = new Scanner(System.in);
   WordElapser.writeWordWithTimeDelay(
"Good to see you again Captain, have you slept well? Select a menu option:",timeToWrite);
   ColorChanger.printTextToGreen("_|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|\n" +
   "___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|__");
   ColorChanger.printTextToBlue("- NEW GAME --> 1");
   ColorChanger.printTextToGreen("- CREDITS --> 2");
   ColorChanger.printTextToRed("- EXIT GAME --> 3");
   ColorChanger.printTextToGreen("_|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|___|");
   ColorChanger.printTextToGreen("- - - >"); int selected = scanner.nextInt();
   switch (selected){
     case 1:
       WordElapser.writeWordWithTimeDelay("Genial comenzaste",timeToWrite);
       break;
     case 2:
       ColorChanger.printTextToGreen("/--//--//--//--//--//--//--//--//--/");
       WordElapser.writeWordWithTimeDelay("This game has been developed by Alexandre Torres Bravo and Sergi Andreu Vila",200);
       ColorChanger.printTextToGreen("/--//--//--//--//--//--//--//--//--/");
       ColorChanger.printTextToBlack("© All rights to be reserved...");
       break;
     case 3:
       exitGame();
       break;
   }
  }

  private void startGame() {
  //TODO
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
  public static void main(String[] args){
    menu();
  }
}
