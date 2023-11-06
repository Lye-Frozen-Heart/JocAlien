package com.example.jocconversacionalalien.classes;

public class ZoneInitializer {

    private static final int NO_ROOM = 0;
    public static final int WORKSHOP = 1;
    public static final int OFFICES = 2;
    public static final int MACHINE_ROOM = 3;
    public static final int LOCKER_ROOM = 4;
    public static final int KITCHEN = 5;
    public static final int DINNING_ROOM = 6;
    public static final int BEDROOM = 7;
    public static final int BATHROOM = 8;
    public static final int EXIT_ROOM = 9;

    //CONSTANTS FOR DOORS
    private static final int DOOR_OPEN = 1;
    private static final int DOOR_CLOSED = -1;
    private static final int DOOR_FALSE = 0;
    private static final boolean DOOR_EXISTS = true;
    private static final boolean DOOR_NO_EXISTS = false;


    public static Zone[] setUpZones(Item[] items) {


        //WORKSHOP
        Zone workshop = new Zone();

        workshop.setName("Workshop");
        workshop.setIdZone(WORKSHOP);
        workshop.setHasItem(true);
        workshop.setHasNpc(false);
        workshop.setHasLight(false); //no light default
        workshop.setHasTraps(false);
        workshop.setAccessible(false);
        workshop.setDoors(new boolean[]{DOOR_NO_EXISTS, DOOR_NO_EXISTS, DOOR_EXISTS, DOOR_NO_EXISTS,});
        workshop.setDirections(new int[]{DOOR_FALSE, DOOR_FALSE, DOOR_CLOSED, DOOR_FALSE});
        workshop.setAvailableZones(new int[]{NO_ROOM, NO_ROOM, OFFICES, NO_ROOM});
        workshop.setItems(workshop.addItems(items, WORKSHOP));
        workshop.setDescriptionZone(
                """
                        The workshop...A metallic and steamy place where the dark begins to blur your eyesight. Seems like the lights are off.
                        You should be careful about all the tools, wires and materials that are left on the floor.
                        Ask your personal AI for the details of the work space or use the flashlight for better vision."""
        );


        //OFFICES
        Zone offices = new Zone();

        offices.setName("Offices");
        offices.setIdZone(OFFICES);
        offices.setHasItem(true);
        offices.setHasNpc(false);
        offices.setHasLight(true);
        offices.setHasTraps(false);
        offices.setAccessible(true);
        offices.setDoors(new boolean[]{DOOR_EXISTS, DOOR_EXISTS, DOOR_EXISTS, DOOR_EXISTS});
        offices.setDirections(new int[]{DOOR_OPEN, DOOR_OPEN, DOOR_OPEN, DOOR_OPEN});
        offices.setAvailableZones(new int[]{WORKSHOP, BATHROOM, MACHINE_ROOM, LOCKER_ROOM});
        offices.setItems(offices.addItems(items, OFFICES));
        offices.setDescriptionZone(
                """
                        The principal office! Apparently everything seems quiet and comfy, a perfect place for meetings and study sessions.
                        A plenty of desks and chairs appear in front of you.
                        You remember that your identification card it's in one of that desks drawers.
                        You should get it for the ship access before it's too late..."""
        );


        //MACHINE ROOM
        Zone machineRoom = new Zone();

        machineRoom.setName("Machine Room");
        machineRoom.setIdZone(MACHINE_ROOM);
        machineRoom.setHasItem(false);
        machineRoom.setHasNpc(false);
        machineRoom.setHasLight(true);
        machineRoom.setHasTraps(false);
        machineRoom.setAccessible(true);
        machineRoom.setDoors(new boolean[]{DOOR_EXISTS, DOOR_NO_EXISTS, DOOR_NO_EXISTS, DOOR_NO_EXISTS,});
        machineRoom.setDirections(new int[]{DOOR_OPEN, DOOR_FALSE, DOOR_FALSE, DOOR_FALSE});
        machineRoom.setAvailableZones(new int[]{OFFICES, NO_ROOM, NO_ROOM, NO_ROOM});
        machineRoom.setItems(machineRoom.addItems(items, MACHINE_ROOM));
        machineRoom.setDescriptionZone(
                """
                        You will never stop getting surprised about this part of the ship.
                        A narrow and uncomfortable room.
                        Why does a place like this have to be the principal management room for all the ship?
                        Seems like a psychiatric center... (You think).
                        The lights are open but the fact that this room is pretty closed up and full of soft plates makes you a bit insecure."""
        );


        //LOCKER ROOM
        Zone lockerRoom = new Zone();

        lockerRoom.setName("Locker Room");
        lockerRoom.setIdZone(LOCKER_ROOM);
        lockerRoom.setHasItem(false);
        lockerRoom.setHasNpc(false);
        lockerRoom.setHasLight(true);
        lockerRoom.setHasTraps(false);
        lockerRoom.setAccessible(true);
        lockerRoom.setDoors(new boolean[]{DOOR_NO_EXISTS, DOOR_EXISTS, DOOR_EXISTS, DOOR_NO_EXISTS});
        lockerRoom.setDirections(new int[]{DOOR_FALSE, DOOR_CLOSED, DOOR_CLOSED, DOOR_FALSE});
        lockerRoom.setAvailableZones(new int[]{NO_ROOM, OFFICES, KITCHEN, NO_ROOM});
        lockerRoom.setItems(lockerRoom.addItems(items, LOCKER_ROOM));
        lockerRoom.setDescriptionZone(
                """
                        Coats, suits and other clothes hide in this room.
                        When it's dark everything that does not move appears to be suspicious.
                        You need to get to the other side asap."""
        );


        //KITCHEN
        Zone kitchen = new Zone();

        kitchen.setName("Kitchen");
        kitchen.setIdZone(KITCHEN);
        kitchen.setHasItem(true);
        kitchen.setHasNpc(false);
        kitchen.setHasLight(true); //has light on default
        kitchen.setHasTraps(true); //TODO add trap functionality
        kitchen.setAccessible(true);
        kitchen.setDoors(new boolean[]{DOOR_EXISTS, DOOR_EXISTS, DOOR_NO_EXISTS, DOOR_NO_EXISTS});
        kitchen.setDirections(new int[]{DOOR_CLOSED, DOOR_CLOSED, DOOR_FALSE, DOOR_FALSE});
        kitchen.setAvailableZones(new int[]{LOCKER_ROOM, DINNING_ROOM, NO_ROOM, NO_ROOM});
        kitchen.setItems(kitchen.addItems(items, KITCHEN));
        kitchen.setDescriptionZone(
                "The metallic sound of the cooking tools itch in your ears.\nDon't get too close " +
                        "to the ones that are sharp, the hunter can smell your fear but also your blood."
        );


        //DINING ROOM
        Zone dinningRoom = new Zone();

        dinningRoom.setName("Dinning Room");
        dinningRoom.setIdZone(DINNING_ROOM);
        dinningRoom.setHasItem(false);
        dinningRoom.setHasNpc(false);
        dinningRoom.setHasLight(false);
        dinningRoom.setHasTraps(false); //TODO set gas trap 4 turns to leave the room
        dinningRoom.setAccessible(true);
        dinningRoom.setDoors(new boolean[]{DOOR_NO_EXISTS, DOOR_EXISTS, DOOR_EXISTS, DOOR_EXISTS});
        dinningRoom.setDirections(new int[]{DOOR_FALSE, DOOR_CLOSED, DOOR_CLOSED, DOOR_CLOSED});
        dinningRoom.setAvailableZones(new int[]{NO_ROOM, BEDROOM, EXIT_ROOM, KITCHEN});
        dinningRoom.setItems(dinningRoom.addItems(items, DINNING_ROOM));
        dinningRoom.setDescriptionZone(
                "A subliminal place to be.\nDesks and chairs get along your entire sight.\n" +
                        "The darkness and the well ordered room start to get you nervous and dizzy."
        );


        //BEDROOM
        Zone bedRoom = new Zone();

        bedRoom.setName("Bedroom");
        bedRoom.setIdZone(BEDROOM);
        bedRoom.setHasItem(false);
        bedRoom.setHasTraps(false);
        bedRoom.setHasNpc(false);
        bedRoom.setHasLight(true);
        bedRoom.setAccessible(true);
        bedRoom.setDoors(new boolean[]{DOOR_EXISTS, DOOR_NO_EXISTS, DOOR_NO_EXISTS, DOOR_EXISTS});
        bedRoom.setDirections(new int[]{DOOR_CLOSED, DOOR_FALSE, DOOR_FALSE, DOOR_CLOSED});
        bedRoom.setAvailableZones(new int[]{BATHROOM, NO_ROOM, NO_ROOM, DINNING_ROOM});
        bedRoom.setItems(bedRoom.addItems(items, BEDROOM));
        bedRoom.setDescriptionZone(
                "Get comfy, take a sleep, dream about everything you could be doing right now\n " +
                        "but remember, it is looking at you and your actions..."
        );


        //BATHROOM
        Zone bathRooms = new Zone();

        bathRooms.setName("bathroom");
        bathRooms.setIdZone(BATHROOM);
        bathRooms.setHasItem(false);
        bathRooms.setHasNpc(false);
        bathRooms.setHasLight(true);
        bathRooms.setHasTraps(false);
        bathRooms.setAccessible(true);
        bathRooms.setDoors(new boolean[]{DOOR_NO_EXISTS, DOOR_NO_EXISTS, DOOR_EXISTS, DOOR_EXISTS});
        bathRooms.setDirections(new int[]{DOOR_FALSE, DOOR_FALSE, DOOR_CLOSED, DOOR_CLOSED});
        bathRooms.setAvailableZones(new int[]{NO_ROOM, NO_ROOM, BEDROOM, OFFICES});
        bathRooms.setItems(bathRooms.addItems(items, BATHROOM));
        bathRooms.setDescriptionZone(
                """
                        A pretty smelly place.
                        Don't get nauseous coming along the water closets and also don't get too close to the mirrors.
                        Someone could be watching."""
        );


        //EXIT ROOM
        Zone exitRoom = new Zone();

        exitRoom.setName("Exit");
        exitRoom.setIdZone(EXIT_ROOM);
        exitRoom.setHasItem(false);
        exitRoom.setHasNpc(false);
        exitRoom.setHasLight(true);
        exitRoom.setAccessible(false);
        exitRoom.setHasTraps(false);
        exitRoom.setDoors(new boolean[]{DOOR_EXISTS, DOOR_NO_EXISTS, DOOR_NO_EXISTS, DOOR_NO_EXISTS,});
        exitRoom.setDirections(new int[]{DOOR_CLOSED, DOOR_FALSE, DOOR_FALSE, DOOR_FALSE});
        exitRoom.setAvailableZones(new int[]{DINNING_ROOM, NO_ROOM, NO_ROOM, NO_ROOM});
        exitRoom.setItems(exitRoom.addItems(items, EXIT_ROOM));
        exitRoom.setDescriptionZone(
                """
                        Finally!
                        You see the empty dark of the void absorbing the light for every star you see.
                        You might be able to use something to force the door and take a escape capsule and scape for ever this mad place."""
        );


        return new Zone[]{
                workshop, offices, machineRoom,
                lockerRoom, kitchen, dinningRoom,
                bedRoom, bathRooms, exitRoom,
        };
    }

}
