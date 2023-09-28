package com.example.jocconversacionalalien.classes;

import java.util.Scanner;

public class Game {
  private int countTurn;
  Zone[] zones = {};
  private static void menu() {
     final int timeToWrite = 120;
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
       WordElapser.writeWordWithTimeDelay("This game has been developed by Alexandre Torres Bravo and Sergi Andreu Vila",timeToWrite);
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
  private static Zone[] setUpZones(){
    Zone[] zonesToReturn = null;
    Zone workshop = new Zone();workshop.setIdZone(1);
    //Parámetros del taller
    workshop.setHasItem(false);workshop.setHasNpc(false);workshop.setHasLight(true);
    workshop.setDoors(new boolean[]{false, false, true, false});workshop.setDirections(new int[]{-1,-1,1,-1});
    workshop.setAccessible(true);workshop.setHasTraps(false);
    //
    Zone offices = new Zone();offices.setIdZone(2);
    //Parámetros de las oficinas

    //
    Zone machineRoom = new Zone(); machineRoom.setIdZone(3);
    //Parámetros de la sala de máquinas

    //
    Zone lockerRoom = new Zone(); lockerRoom.setIdZone(4);
    //Parámetros del vestuario

    //
    Zone kitchen = new Zone(); kitchen.setIdZone(5);
    //Parámetros de la cocina

    //
    Zone dinningRoom = new Zone(); dinningRoom.setIdZone(6);
    //Parámetros del comedor

    //
    Zone bedRoom = new Zone(); bedRoom.setIdZone(7);
    //Params del dormitorio

    //
    Zone bathRooms = new Zone(); bathRooms.setIdZone(8);
    //Params de los Baños...

    //
    Zone exitRoom = new Zone(); exitRoom.setIdZone(9);
    exitRoom.setHasItem(false);exitRoom.setHasNpc(false);exitRoom.setHasLight(true);
    exitRoom.setDoors(new boolean[]{true, false, false, false});exitRoom.setDirections(new int[]{1,-1,-1,-1});
    exitRoom.setAccessible(false);exitRoom.setHasTraps(false);
    //Params de la salida
    //Zone propulsors/Space = new Zone(); propulsors.setIdZone(10); TODO No hay décima zona únicamente hay 9 en todo el mapa!
    zonesToReturn = new Zone[]{workshop, offices, machineRoom, lockerRoom, kitchen, dinningRoom, bedRoom, bathRooms, exitRoom};
      return zonesToReturn;
  }
  public static void main(String[] args){
    menu();
  }
}
