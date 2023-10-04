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
    Zone workshop = new Zone();workshop.setIdZone(1);
    //Parámetros del taller
    workshop.setHasItem(true);workshop.setHasNpc(false);workshop.setHasLight(false);
    workshop.setDoors(new boolean[]{false, false, true, false});workshop.setDirections(new int[]{-1,-1,1,-1});
    workshop.setAccessible(true);workshop.setHasTraps(false);
    workshop.setAvailableZones(new int[]{-1, -1, 2, -1});
    workshop.setDescriptionZone("The workshop...A metallic and steamy place where the dark begins to blur your eyesight. Seems like the lights are off.You " +
    "should be carefull about all the tools, wires and materials that are left on the floor. Ask your personal AI for the details of the work space or use the flaslight " +
    "for better vision.");
    //Taller es zona de item, sin trampas ni nada. Salida por abajo ya que és única. No hay luz
    Zone offices = new Zone();offices.setIdZone(2);
    //Parámetros de las oficinas
    offices.setHasItem(true);offices.setHasNpc(false);offices.setHasLight(true);
    offices.setDoors(new boolean[]{true,true,true,true});offices.setDirections(new int[]{1,1,1,1});
    offices.setAccessible(true);offices.setHasTraps(false);
    offices.setAvailableZones(new int[]{1,8,3,4});
    offices.setDescriptionZone("The principal office! Apparently everything seems quiet and comfy, a perfect place for meetings and study sessions. A plenty of desks and chairs " +
    "appear in front of you. You remember that your identification card it's in one of that desks drawers. You should get it for the ship access before it's too late...");
    //Ya que es la oficina. Sin trampas y con total acceso. Hay luz
    Zone machineRoom = new Zone(); machineRoom.setIdZone(3);
    //Parámetros de la sala de máquinas
    machineRoom.setHasItem(false);machineRoom.setHasNpc(false);machineRoom.setHasLight(true);
    machineRoom.setDoors(new boolean[]{true,false,false,false});machineRoom.setDirections(new int[]{1,-1,-1,-1});
    machineRoom.setAccessible(false);machineRoom.setHasTraps(false);
    machineRoom.setAvailableZones(new int[]{2,-1,-1,-1});
    machineRoom.setDescriptionZone("You will never stop getting surprised about this part of the ship. A narrow and uncomfortable room. Why does a place like this have to be " +
    "the principal management room for all the ship? Seems like a psychiatric center... (You think). The lights are open but the fact that this room is pretty closed up and full of soft plates" +
    " makes you a bit insecure.");
    //O sala de comandos, todo por defecto.
    Zone lockerRoom = new Zone(); lockerRoom.setIdZone(4);
    //Parámetros del vestuario
    lockerRoom.setHasItem(false);lockerRoom.setHasNpc(false);lockerRoom.setHasLight(false);
    lockerRoom.setDoors(new boolean[]{false,true,true,false});lockerRoom.setDirections(new int[]{-1,1,1,-1});
    lockerRoom.setAccessible(false);lockerRoom.setHasTraps(false);
    lockerRoom.setAvailableZones(new int[]{-1,2,5,-1});
    lockerRoom.setDescriptionZone("A creepy feel gets your spine...Everything in the dark seems suspicious at the locker room. Perhaps you shouldn't stay long." +
    " The coats, hats and clothers are starting to acquire life and they watch you as you get to the other side of the room.");
    //
    Zone kitchen = new Zone(); kitchen.setIdZone(5);
    //Parámetros de la cocina
    kitchen.setHasItem(true);kitchen.setHasNpc(false);kitchen.setHasLight(true);
    kitchen.setDoors(new boolean[]{true,true,false,false});kitchen.setDirections(new int[]{1,1,-1,-1});
    kitchen.setAccessible(true);kitchen.setHasTraps(false);
    kitchen.setAvailableZones(new int[]{4,6,-1,-1});
    kitchen.setDescriptionZone("Apparently not everything is yummy when you are being chased. Be careful with the cooking tools and sharping materials it's" +
    " said that the Hunter follows your blood wherever you go.");
    //La cocina es donde se sitúan los donuts, hay luz y sin trampas.
    Zone dinningRoom = new Zone(); dinningRoom.setIdZone(6);
    //Parámetros del comedor
    dinningRoom.setHasItem(false);dinningRoom.setHasNpc(false);dinningRoom.setHasLight(false);
    dinningRoom.setDoors(new boolean[]{false,true,true,true});dinningRoom.setDirections(new int[]{-1,1,1,1});
    dinningRoom.setAccessible(true);kitchen.setHasTraps(true);
    dinningRoom.setAvailableZones(new int[]{-1,7,9,5});
    dinningRoom.setDescriptionZone("Subliminal place this is. A room full of tables and chairs wherever you look at it. Can you get out? You are starting to get" +
    " anxious.");
    //En la cocina pondremos el estado del gas... Ha habido una fuga y no pueden pasar más de 2 turnos para salir
    Zone bedRoom = new Zone(); bedRoom.setIdZone(7);
    //Params del dormitorio
    bedRoom.setHasItem(false);bedRoom.setHasNpc(false);bedRoom.setHasLight(true);
    bedRoom.setDoors(new boolean[]{true,false,false,true});bedRoom.setDirections(new int[]{1,-1,-1,1});
    bedRoom.setAvailableZones(new int[]{8,-1,-1,6});
    //
    Zone bathRooms = new Zone(); bathRooms.setIdZone(8);
    //Params de los Baños...
    bathRooms.setAvailableZones(new int[]{-1,-1,7,2});

    //
    Zone exitRoom = new Zone(); exitRoom.setIdZone(9);
    //Params de la salida
    exitRoom.setHasItem(false);exitRoom.setHasNpc(false);exitRoom.setHasLight(true);
    exitRoom.setDoors(new boolean[]{true, false, false, false});exitRoom.setDirections(new int[]{1,-1,-1,-1});
    exitRoom.setAccessible(false);exitRoom.setHasTraps(false);
    exitRoom.setAvailableZones(new int[]{6,-1,-1,-1});
    exitRoom.setDescriptionZone("Finally! You see the empty dark of the void absorbing the light for every star you see. Now you can take one escape capsule and" +
    " ensure your destiny hasn't been settled right now. You can live once again, congrats! YOU WON!");
    //
    //Zone propulsors/Space = new Zone(); propulsors.setIdZone(10); TODO No hay décima zona únicamente hay 9 en todo el mapa!
    zonesToReturn = new Zone[]{workshop, offices, machineRoom, lockerRoom, kitchen, dinningRoom, bedRoom, bathRooms, exitRoom};
      return zonesToReturn;
  }
  public static void main(String[] args){
    menu();
  }
}
