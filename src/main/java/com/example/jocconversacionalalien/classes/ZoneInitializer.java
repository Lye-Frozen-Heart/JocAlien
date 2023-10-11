package com.example.jocconversacionalalien.classes;

public class ZoneInitializer {

    private static final int NO_ROOM = 0;
    private static final int WORKSHOP = 1;
    private static final int OFFICES = 2;
    private static final int MACHINE_ROOM = 3;
    private static final int LOCKER_ROOM = 4;
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
    public static Zone[] setUpZones() {
        //TODO La función devolverá las zonas con todos los parámetros de defecto
        //TODO Nada randomizado o con items solamente lo básico

        Zone[] zonesToReturn;


        Zone workshop = new Zone();
        workshop.setIdZone(WORKSHOP);

        //Parámetros del taller
        workshop.setHasItem(true);
        workshop.setHasNpc(false);
        workshop.setHasLight(false);
        workshop.setHasTraps(false);
        workshop.setAccessible(false);
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
        workshop.setAvailableZones(
                new int[] { NO_ROOM, NO_ROOM, OFFICES, NO_ROOM }
        );
        workshop.setDescriptionZone(
        "The workshop...A metallic and steamy place where the dark begins to blur your eyesight. Seems like the lights are off.\nYou " +
        "should be carefull about all the tools, wires and materials that are left on the floor.\nAsk your personal AI for the details" +
        " of the work space or use the flaslight " +
        "for better vision."
        );
        //Taller es zona de item, sin trampas ni nada. Salida por abajo ya que és única. No hay luz
        Zone offices = new Zone();
        offices.setIdZone(OFFICES);
        //Parámetros de las oficinas
        offices.setHasItem(true);
        offices.setHasNpc(false);
        offices.setHasLight(true);
        offices.setHasTraps(false);
        offices.setAccessible(true);
        offices.setDoors(
                new boolean[] { DOOR_EXISTS, DOOR_EXISTS, DOOR_EXISTS, DOOR_EXISTS }
        );
        offices.setDirections(
                new int[] { DOOR_OPEN, DOOR_OPEN, DOOR_OPEN, DOOR_OPEN }
        );
        offices.setAvailableZones(
                new int[] { WORKSHOP, BATHROOM, MACHINE_ROOM, LOCKER_ROOM }
        );
        offices.setDescriptionZone(
        "The principal office! Apparently everything seems quiet and comfy, a perfect place for meetings and study sessions.\nA plenty of desks and chairs " +
        "appear in front of you.\nYou remember that your identification card it's in one of that desks drawers.\nYou should get it for the ship access before it's too late..."
        );
        //Ya que es la oficina. Sin trampas y con total acceso. Hay luz
        Zone machineRoom = new Zone();
        machineRoom.setIdZone(MACHINE_ROOM);
        //Parámetros de la sala de máquinas
        machineRoom.setHasItem(false);
        machineRoom.setHasNpc(false);
        machineRoom.setHasLight(true);
        machineRoom.setHasTraps(false);
        machineRoom.setAccessible(true);
        machineRoom.setDoors(
                new boolean[] {
                        DOOR_EXISTS,
                        DOOR_NO_EXISTS,
                        DOOR_NO_EXISTS,
                        DOOR_NO_EXISTS,
                }
        );
        machineRoom.setDirections(
                new int[] { DOOR_OPEN, DOOR_FALSE, DOOR_FALSE, DOOR_FALSE }
        );
        machineRoom.setAvailableZones(
                new int[] { OFFICES, NO_ROOM, NO_ROOM, NO_ROOM }
        );
        machineRoom.setDescriptionZone(
        "You will never stop getting surprised about this part of the ship.\nA narrow and uncomfortable room.\nWhy does a place like this have to be " +
        "the principal management room for all the ship?\nSeems like a psychiatric center... (You think).\nThe lights are open but the fact that this room is pretty closed up and full of soft plates" +
        " makes you a bit insecure."
        );
        //
        Zone lockerRoom = new Zone();
        lockerRoom.setIdZone(LOCKER_ROOM);
        //Parámetros del vestuario
        lockerRoom.setHasItem(false);
        lockerRoom.setHasNpc(false);
        lockerRoom.setHasLight(true);
        lockerRoom.setHasTraps(false);
        lockerRoom.setAccessible(true);
        lockerRoom.setDoors(
                new boolean[] { DOOR_NO_EXISTS, DOOR_EXISTS, DOOR_EXISTS, DOOR_NO_EXISTS }
        );
        lockerRoom.setDirections(
                new int[] { DOOR_FALSE, DOOR_CLOSED, DOOR_CLOSED, DOOR_FALSE }
        );
        lockerRoom.setAvailableZones(
                new int[] { NO_ROOM, OFFICES, KITCHEN, NO_ROOM }
        );
        lockerRoom.setDescriptionZone(
        "Coats, suits and other clothes hide in this room.\nWhen it's dark " +
        "everything that does not move appears to be suspicious.\nYou need to get to the other side asap."
        );
        //
        Zone kitchen = new Zone();
        kitchen.setIdZone(KITCHEN);
        //Parámetros de la cocina
        kitchen.setHasItem(true);
        kitchen.setHasNpc(false);
        kitchen.setHasLight(true);
        kitchen.setHasTraps(true);
        kitchen.setAccessible(true);
        kitchen.setDoors(
                new boolean[] { DOOR_EXISTS, DOOR_EXISTS, DOOR_NO_EXISTS, DOOR_NO_EXISTS }
        );
        kitchen.setDirections(
                new int[] { DOOR_CLOSED, DOOR_CLOSED, DOOR_FALSE, DOOR_FALSE }
        );
        kitchen.setAvailableZones(
                new int[] { LOCKER_ROOM, DINNING_ROOM, NO_ROOM, NO_ROOM }
        );
        kitchen.setDescriptionZone(
        "The metallic sound of the cooking tools itch in your ears.\nDon't get too close " +
        "to the ones that are sharp, the hunter can smell your fear but also your blood."
        );
        //La cocina es donde se sitúan los donuts, hay luz y trampas.
        Zone dinningRoom = new Zone();
        dinningRoom.setIdZone(DINNING_ROOM);
        //Parámetros del comedor
        dinningRoom.setHasItem(false);
        dinningRoom.setHasNpc(false);
        dinningRoom.setHasLight(false);
        dinningRoom.setHasTraps(false);
        dinningRoom.setAccessible(true);
        dinningRoom.setDoors(
                new boolean[] { DOOR_NO_EXISTS, DOOR_EXISTS, DOOR_EXISTS, DOOR_EXISTS }
        );
        dinningRoom.setDirections(
                new int[] { DOOR_FALSE, DOOR_CLOSED, DOOR_CLOSED, DOOR_CLOSED }
        );
        dinningRoom.setAvailableZones(
                new int[] { NO_ROOM, BEDROOM, EXIT_ROOM, KITCHEN }
        );
        dinningRoom.setDescriptionZone(
        "A subliminal place to be.Desks and chairs get along your entire sight.\n" +
        "The darkness and the well ordered room start to get you nervous and dizzy."
        );
        //En la cocina pondremos el estado del gas... Ha habido una fuga y no pueden pasar más de 4 turnos para salir
        Zone bedRoom = new Zone();
        bedRoom.setIdZone(BEDROOM);
        //Params del dormitorio
        bedRoom.setHasItem(false);
        bedRoom.setHasTraps(false);
        bedRoom.setHasNpc(false);
        bedRoom.setHasLight(true);
        bedRoom.setAccessible(true);
        bedRoom.setDoors(
                new boolean[] { DOOR_EXISTS, DOOR_NO_EXISTS, DOOR_NO_EXISTS, DOOR_EXISTS }
        );
        bedRoom.setDirections(
                new int[] { DOOR_CLOSED, DOOR_FALSE, DOOR_FALSE, DOOR_CLOSED }
        );
        bedRoom.setAvailableZones(
                new int[] { BATHROOM, NO_ROOM, NO_ROOM, DINNING_ROOM }
        );
        bedRoom.setDescriptionZone(
        "Get comfy, take a sleep, dream about everything you could be doing right now\n " +
        "but remember, it is looking at you and your actions..."
        );
        //
        Zone bathRooms = new Zone();
        bathRooms.setIdZone(BATHROOM);
        //Params de los Baños...
        bathRooms.setHasItem(false);
        bathRooms.setHasNpc(false);
        bathRooms.setHasLight(true);
        bathRooms.setHasTraps(false);
        bathRooms.setAccessible(true);
        bathRooms.setDoors(
                new boolean[] { DOOR_NO_EXISTS, DOOR_NO_EXISTS, DOOR_EXISTS, DOOR_EXISTS }
        );
        bathRooms.setDirections(
                new int[] { DOOR_FALSE, DOOR_FALSE, DOOR_CLOSED, DOOR_CLOSED }
        );
        bathRooms.setAvailableZones(
                new int[] { NO_ROOM, NO_ROOM, BEDROOM, OFFICES }
        );
        bathRooms.setDescriptionZone(
        "A pretty smelly place.\nDon't get nauseous coming along the " +
        "water closets and also don't get too close to the mirrors.\nSomeone could be watching."
        );
        //
        Zone exitRoom = new Zone();
        exitRoom.setIdZone(EXIT_ROOM);
        //Params de la salida
        exitRoom.setHasItem(false);
        exitRoom.setHasNpc(false);
        exitRoom.setHasLight(true);
        exitRoom.setAccessible(false);
        exitRoom.setHasTraps(false);
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
        exitRoom.setAvailableZones(
                new int[] { DINNING_ROOM, NO_ROOM, NO_ROOM, NO_ROOM }
        );
        exitRoom.setDescriptionZone(
        "Finally!\nYou see the empty dark of the void absorbing the light for every star you see.\nNow you can take one escape capsule and" +
        " ensure your destiny hasn't been settled right now.\nYou can live once again, congrats! YOU WON!"
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

}
