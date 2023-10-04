package com.example.jocconversacionalalien.classes;

import java.util.Scanner;

public class Game {

  //CONSTANTS FOR ROOM ID
  private static final int WORKSHOP = 1;
  private static final int OFFICES = 2;
  private static final int MACHINE_ROOM = 3;
  private static final int LOKER_ROOM = 4;
  private static final int KITCHEN = 5;
  private static final int DINNING_ROOM = 6;
  private static final int BADROOM = 7;
  private static final int BATHROOM = 8;
  private static final int EXIT_ROOM = 9;

  //CONSTANTS FOR DOORS
  private static final int DOOR_OPEN = 1;
  private static final int DOOR_CLOSED = -1;
  private static final int DOOR_FALSE = 0;
  private static final boolean DOOR_EXISTS = true;
  private static final boolean DOOR_NO_EXISTS = false;

  private int countTurn;

  Zone[] zones = {};

  private static void menu() {
    final int timeToWrite = 120;
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

  private static Zone[] setUpZones() {
    //TODO La función devolverá las zonas con todos los parámetros de defecto
    //TODO Nada randomizado o con items solamente lo básico
    Zone[] zonesToReturn;
    Zone workshop = new Zone();
    workshop.setIdZone(1);
    //Parámetros del taller
    workshop.setHasItem(true);
    workshop.setHasNpc(false);
    workshop.setHasLight(false);
    workshop.setDoors(new boolean[] { DOOR_NO_EXISTS, DOOR_NO_EXISTS, DOOR_EXISTS, DOOR_NO_EXISTS });
    workshop.setDirections(new int[] { DOOR_FALSE, DOOR_FALSE, DOOR_OPEN,  DOOR_FALSE});
    workshop.setAvailableZones(null);
    workshop.setAccessible(true);
    workshop.setHasTraps(false);
    workshop.setDescriptionZone(
      "The workshop...A metallic and steamy place where the dark begins to blur your eyesight. Seems like the lights are off.You " +
      "should be carefull about all the tools, wires and materials that are left on the floor. Ask your personal AI for the details of the work space or use the flaslight " +
      "for better vision."
    );
    //Taller es zona de item, sin trampas ni nada. Salida por abajo ya que és única. No hay luz
    Zone offices = new Zone();
    offices.setIdZone(2);
    //Parámetros de las oficinas
    offices.setHasItem(true);
    offices.setHasNpc(false);
    offices.setHasLight(true);
    offices.setDoors(new boolean[] { true, true, true, true });
    offices.setDirections(new int[] { 1, 1, 1, 1 });
    offices.setAccessible(true);
    offices.setHasTraps(false);
    offices.setDescriptionZone(
      "The principal office! Apparently everything seems quiet and comfy, a perfect place for meetings and study sessions. A plenty of desks and chairs " +
      "appear in front of you. You remember that your identification card it's in one of that desks drawers. You should get it for the ship access before it's too late..."
    );
    //Ya que es la oficina. Sin trampas y con total acceso. Hay luz
    Zone machineRoom = new Zone();
    machineRoom.setIdZone(3);
    //Parámetros de la sala de máquinas
    machineRoom.setHasItem(false);
    machineRoom.setHasNpc(false);
    machineRoom.setHasLight(true);
    machineRoom.setDoors(new boolean[] { true, false, false, false });
    machineRoom.setDirections(new int[] { 1, -1, -1, -1 });
    machineRoom.setAvailableZones(null);
    machineRoom.setAccessible(false);
    machineRoom.setHasTraps(false);
    machineRoom.setDescriptionZone(
      "You will never stop getting surprised about this part of the ship. A narrow and uncomfortable room. Why does a place like this have to be " +
      "the principal management room for all the ship? Seems like a psychiatric center... (You think). The lights are open but the fact that this room is pretty closed up and full of soft plates" +
      " makes you a bit insecure."
    );

    //
    Zone lockerRoom = new Zone();
    lockerRoom.setIdZone(4);
    //Parámetros del vestuario

    //
    Zone kitchen = new Zone();
    kitchen.setIdZone(5);
    //Parámetros de la cocina
    kitchen.setHasItem(true);
    kitchen.setHasNpc(false);
    kitchen.setHasLight(true);
    kitchen.setDoors(new boolean[] { true, true, false, false });
    kitchen.setDirections(new int[] { 1, 1, -1, -1 });
    kitchen.setAccessible(true);
    kitchen.setHasTraps(false);
    //La cocina es donde se sitúan los donuts, hay luz y sin trampas.
    Zone dinningRoom = new Zone();
    dinningRoom.setIdZone(6);
    //Parámetros del comedor
    dinningRoom.setHasItem(false);
    dinningRoom.setHasNpc(false);
    dinningRoom.setHasLight(false);
    dinningRoom.setDoors(new boolean[] { false, true, true, true });
    dinningRoom.setDirections(new int[] { -1, 1, 1, 1 });
    dinningRoom.setAccessible(true);
    kitchen.setHasTraps(true);
    //En la cocina pondremos el estado del gas... Ha habido una fuga y no pueden pasar más de 2 turnos para salir
    Zone bedRoom = new Zone();
    bedRoom.setIdZone(7);
    //Params del dormitorio

    //
    Zone bathRooms = new Zone();
    bathRooms.setIdZone(8);
    //Params de los Baños...

    //
    Zone exitRoom = new Zone();
    exitRoom.setIdZone(9);
    //Params de la salida
    exitRoom.setHasItem(false);
    exitRoom.setHasNpc(false);
    exitRoom.setHasLight(true);
    exitRoom.setDoors(new boolean[] { true, false, false, false });
    exitRoom.setDirections(new int[] { 1, -1, -1, -1 });
    exitRoom.setAccessible(false);
    exitRoom.setHasTraps(false);
    exitRoom.setDescriptionZone(
      "Finally! You see the empty dark of the void absorbing the light for every star you see. Now you can take one escape capsule and" +
      " ensure your destiny hasn't been settled right now. You can live once again, congrats! YOU WON!"
    );
    //
    //Zone propulsors/Space = new Zone(); propulsors.setIdZone(10); TODO No hay décima zona únicamente hay 9 en todo el mapa!
    zonesToReturn =
      new Zone[] {
        workshop,
        offices,
        machineRoom,
        lockerRoom,
        kitchen,
        dinningRoom,
        bedRoom,
        bathRooms,
        exitRoom,
      };
    return zonesToReturn;
  }

  public static void main(String[] args) {
    menu();
  }
}
