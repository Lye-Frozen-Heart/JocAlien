package com.example.jocconversacionalalien.classes;

import java.util.Scanner;

public class Game {

  //CONSTANTS FOR ROOM ID
  private static final int NO_ROOM = 0;
  private static final int WORKSHOP = 1;
  private static final int OFFICES = 2;
  private static final int MACHINE_ROOM = 3;
  private static final int LOKER_ROOM = 4;
  private static final int KITCHEN = 5;
  private static final int DINNING_ROOM = 6;
  private static final int BEDROOM = 7;
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

  private static Zone[] setUpZones(){
    //TODO La función devolverá las zonas con todos los parámetros de defecto
    //TODO Nada randomizado o con items solamente lo básico
    Zone[] zonesToReturn;
    Zone workshop = new Zone();
    workshop.setIdZone(WORKSHOP);
    //Parámetros del taller
    workshop.setHasItem(true);
    workshop.setHasNpc(false);
    workshop.setHasLight(false);
    workshop.setDoors(
      new boolean[] {
        DOOR_NO_EXISTS,
        DOOR_NO_EXISTS,
        DOOR_EXISTS,
        DOOR_NO_EXISTS,
      }
    );
    workshop.setDirections(
      new int[] { DOOR_FALSE, DOOR_FALSE, DOOR_CLOSED, DOOR_FALSE }
    );
    workshop.setAccessible(true);
    workshop.setHasTraps(false);
    workshop.setAvailableZones(
      new int[] { NO_ROOM, NO_ROOM, OFFICES, NO_ROOM }
    );
    workshop.setDescriptionZone(
      "The workshop...A metallic and steamy place where the dark begins to blur your eyesight. Seems like the lights are off.You " +
      "should be carefull about all the tools, wires and materials that are left on the floor. Ask your personal AI for the details of the work space or use the flaslight " +
      "for better vision."
    );
    //Taller es zona de item, sin trampas ni nada. Salida por abajo ya que és única. No hay luz
    Zone offices = new Zone();
    offices.setIdZone(OFFICES);
    //Parámetros de las oficinas
    offices.setHasItem(true);
    offices.setHasNpc(false);
    offices.setHasLight(true);
    offices.setDoors(
      new boolean[] { DOOR_EXISTS, DOOR_EXISTS, DOOR_EXISTS, DOOR_EXISTS }
    );
    offices.setDirections(
      new int[] { DOOR_CLOSED, DOOR_CLOSED, DOOR_CLOSED, DOOR_CLOSED }
    );
    offices.setAccessible(true);
    offices.setHasTraps(false);
    offices.setAvailableZones(
      new int[] { WORKSHOP, BATHROOM, MACHINE_ROOM, LOKER_ROOM }
    );
    offices.setDescriptionZone(
      "The principal office! Apparently everything seems quiet and comfy, a perfect place for meetings and study sessions. A plenty of desks and chairs " +
      "appear in front of you. You remember that your identification card it's in one of that desks drawers. You should get it for the ship access before it's too late..."
    );
    //Ya que es la oficina. Sin trampas y con total acceso. Hay luz
    Zone machineRoom = new Zone();
    machineRoom.setIdZone(MACHINE_ROOM);
    //Parámetros de la sala de máquinas
    machineRoom.setHasItem(false);
    machineRoom.setHasNpc(false);
    machineRoom.setHasLight(true);
    machineRoom.setDoors(
      new boolean[] {
        DOOR_EXISTS,
        DOOR_NO_EXISTS,
        DOOR_NO_EXISTS,
        DOOR_NO_EXISTS,
      }
    );
    machineRoom.setDirections(
      new int[] { DOOR_CLOSED, DOOR_FALSE, DOOR_FALSE, DOOR_FALSE }
    );
    machineRoom.setAccessible(false);
    machineRoom.setHasTraps(false);
    machineRoom.setAvailableZones(
      new int[] { OFFICES, NO_ROOM, NO_ROOM, NO_ROOM }
    );
    machineRoom.setDescriptionZone(
      "You will never stop getting surprised about this part of the ship. A narrow and uncomfortable room. Why does a place like this have to be " +
      "the principal management room for all the ship? Seems like a psychiatric center... (You think). The lights are open but the fact that this room is pretty closed up and full of soft plates" +
      " makes you a bit insecure."
    );

    //
    Zone lockerRoom = new Zone();
    lockerRoom.setIdZone(LOKER_ROOM);
    lockerRoom.setAvailableZones(
      new int[] { NO_ROOM, OFFICES, KITCHEN, NO_ROOM }
    );
    //Parámetros del vestuario

    //
    Zone kitchen = new Zone();
    kitchen.setIdZone(KITCHEN);
    //Parámetros de la cocina
    kitchen.setHasItem(true);
    kitchen.setHasNpc(false);
    kitchen.setHasLight(true);
    kitchen.setDoors(
      new boolean[] { DOOR_EXISTS, DOOR_EXISTS, DOOR_NO_EXISTS, DOOR_NO_EXISTS }
    );
    kitchen.setDirections(
      new int[] { DOOR_CLOSED, DOOR_CLOSED, DOOR_FALSE, DOOR_FALSE }
    );
    kitchen.setAccessible(true);
    kitchen.setHasTraps(false);
    kitchen.setAvailableZones(
      new int[] { LOKER_ROOM, DINNING_ROOM, NO_ROOM, NO_ROOM }
    );
    //La cocina es donde se sitúan los donuts, hay luz y sin trampas.
    Zone dinningRoom = new Zone();
    dinningRoom.setIdZone(DINNING_ROOM);
    //Parámetros del comedor
    dinningRoom.setHasItem(false);
    dinningRoom.setHasNpc(false);
    dinningRoom.setHasLight(false);
    dinningRoom.setDoors(
      new boolean[] { DOOR_NO_EXISTS, DOOR_EXISTS, DOOR_EXISTS, DOOR_EXISTS }
    );
    dinningRoom.setDirections(
      new int[] { DOOR_FALSE, DOOR_CLOSED, DOOR_CLOSED, DOOR_CLOSED }
    );
    dinningRoom.setAccessible(true);
    kitchen.setHasTraps(true);
    dinningRoom.setAvailableZones(
      new int[] { NO_ROOM, BEDROOM, EXIT_ROOM, KITCHEN }
    );
    //En la cocina pondremos el estado del gas... Ha habido una fuga y no pueden pasar más de 2 turnos para salir
    Zone bedRoom = new Zone();
    bedRoom.setIdZone(BEDROOM);
    //Params del dormitorio
    bedRoom.setAvailableZones(
      new int[] { BATHROOM, NO_ROOM, NO_ROOM, DINNING_ROOM }
    );
    //
    Zone bathRooms = new Zone();
    bathRooms.setIdZone(BATHROOM);
    //Params de los Baños...
    bathRooms.setAvailableZones(
      new int[] { NO_ROOM, NO_ROOM, BEDROOM, OFFICES }
    );

    //
    Zone exitRoom = new Zone();
    exitRoom.setIdZone(EXIT_ROOM);
    //Params de la salida
    exitRoom.setHasItem(false);
    exitRoom.setHasNpc(false);
    exitRoom.setHasLight(true);
    exitRoom.setDoors(
      new boolean[] {
        DOOR_EXISTS,
        DOOR_NO_EXISTS,
        DOOR_NO_EXISTS,
        DOOR_NO_EXISTS,
      }
    );
    exitRoom.setDirections(
      new int[] { DOOR_CLOSED, DOOR_FALSE, DOOR_FALSE, DOOR_FALSE }
    );
    exitRoom.setAccessible(false);
    exitRoom.setHasTraps(false);
    exitRoom.setAvailableZones(
      new int[] { DINNING_ROOM, NO_ROOM, NO_ROOM, NO_ROOM }
    );
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
  public static void main(String[] args){
    menu();
  }
}
