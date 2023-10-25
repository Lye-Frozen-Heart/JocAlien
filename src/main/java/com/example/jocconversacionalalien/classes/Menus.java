package com.example.jocconversacionalalien.classes;

import java.util.Scanner;

public class Menus {
    static Scanner scanner = new Scanner(System.in);

    static int option = 0;
    static int shift = 0;
    static boolean validAnswer = false;

    private static void setUpItems(Zone[] zones,Item[] items,Player player){
        player.setInventory(player.addItemsInventory());

        zones[player.getIdZone()-1].setItems(Zone.addItems(items));
    }


    public void LightOnMenu(Zone[] zones, Item[] items, Player player, Enemy alien, NonPlayableCharacter npc, ArtificialIntelligence iHall) {
        final int SPEAK_IHALL = 1;
        final int LOOK_DOORS = 2;
        final int LOOK_ITEMS = 3;
        final int OPEN_BACKPACK = 4;
        final int MOVE = 5;
        final int TALK_NPC = 6;
        final int EXIT_GAME = 7;


        zones[player.getIdZone() - 1].getDescriptionZone();
        do {
            do {
                validAnswer = false;
                Strings.MenuLightOnOptions();
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    validAnswer = true;
                } else {
                    Strings.InputError();
                }
                alien.pairShift(shift);
                npc.fourthShift(shift);
            } while (!validAnswer);

            switch (option) {
                case SPEAK_IHALL:
                    SpeakIHall(items, zones, player, iHall,alien,npc);
                    shift++;
                    break;
                case LOOK_DOORS:
                    player.LookAround(zones[player.getIdZone() - 1].getAvailableZones());
                    shift++;
                    break;
                case LOOK_ITEMS:
                    zones[player.getIdZone()-1].printItems();
                    shift++;
                    break;
                case OPEN_BACKPACK:
                    player.printItems();
                    backpackItemSelection(items, player, alien, zones);
                    shift++;
                    break;
                case MOVE:
                    movement(player, zones);
                    zones[player.getIdZone() - 1].getDescriptionZone();
                    shift++;
                    break;
                case TALK_NPC:

                break;
                case EXIT_GAME:
                    Game.exitGame();
                    break;
                default:
                    Strings.InputError();
            }
            if(alien.getIdZone() == player.getIdZone()) Strings.AlienIsHere(); //Si el alien está en la sala...
            if(npc.getIdZone() == player.getIdZone()) Strings.NpcIsHere();
           // if (player.getIdZone() == ZoneInitializer.EXIT_ROOM && player.doPlayerHaveSuit()) option = EXIT_GAME;
        } while (option != EXIT_GAME);

    }

    public void SpeakIHall(Item[] items, Zone[] zones, Player player, ArtificialIntelligence iHall,Enemy alien,NonPlayableCharacter npc) {
        final int FLASHLIGHT_LOCATION = 1;
        final int ALIEN_LOCATION = 2;
        final int OPEN_DOOR = 3;
        final int HELP = 4;
        final int COMPANION_LOCATION = 5;
        final int EXIT_IHALL = 6;
        do {
            do {
                validAnswer = false;
                Strings.MenuIHall();
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    validAnswer = true;
                } else {
                    Strings.InputError();
                }
            } while (!validAnswer);
            switch (option) {
                case FLASHLIGHT_LOCATION:
                    Strings.IHallFlashlightLocation(iHall.askForFlashlight());
                    break;
                case ALIEN_LOCATION:
                    iHall.askForAlien(zones,alien);
                    break;
                case OPEN_DOOR:
                    do {
                        validAnswer = false;
                        Strings.MenuOpenDoor();
                        if (scanner.hasNextInt()) {
                            int direction = scanner.nextInt();
                            if (direction > 0 && direction < 5) {
                                validAnswer = true;
                                player.ToOpen(items, zones, player.getIdZone() - 1, direction - 1);
                            } else {
                                Strings.InputError();
                            }
                        } else {
                            Strings.InputError();
                        }
                    } while (!validAnswer);
                    break;
                case HELP:
                    Strings.IHallHelp();
                    break;
                case COMPANION_LOCATION:
                    iHall.askForNpc(zones,npc);
                case EXIT_IHALL:
                    Strings.IHallExit();
                    break;
                default:
                    Strings.InputError();
            }
        } while (option != EXIT_IHALL);


    }

    private static void backpackItemSelection(Item[] items, Player player, Enemy alien, Zone[] zones) {
        final int EXIT = 0;
        do {
            validAnswer = false;
            Strings.MenuItemSelection();
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option >= 0 && option < items.length + 1) {
                    validAnswer = true;
                } else {
                    Strings.InputError();
                }
            } else {
                Strings.InputError();
            }
        } while (!validAnswer);
        if (option != EXIT) {
            backpackMenu(items, player, option, alien, zones);
        }


    }

    private static void backpackMenu(Item[] items, Player player, int selectedItem, Enemy alien, Zone[] zones) {

        final int ITEM_DESCRIPTION = 1;
        final int USE_ITEM = 2;
        final int DROP_ITEM = 3;
        final int EXIT = 4;

        final int CARD = 0;
        final int NPC_CARD = 1;
        final int TOOL = 2;
        final int FLASHLIGHT = 3;
        final int SPACE_SUIT = 4;
        final int DONUT = 5;


        do {
            do {
                validAnswer = false;
                Strings.MenuBackpack();
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    validAnswer = true;
                } else {
                    Strings.InputError();
                }
            } while (!validAnswer);
            switch (option) {
                case ITEM_DESCRIPTION:
                    player.getItemDescription(selectedItem, items);
                    break;
                case USE_ITEM:
                    switch (selectedItem) {
                        case CARD, NPC_CARD:
                            item.useCard();
                            break;
                        case TOOL:
                            item.useTool(player, alien);
                            break;
                        case FLASHLIGHT:
                            item.useFlashlight(player);
                            break;
                        case SPACE_SUIT:
                            item.useSpaceSuit(player);
                            break;
                        case DONUT:
                            item.useDonut(items, selectedItem, player, alien);
                            break;
                    }
                    break;
                case DROP_ITEM:
                    player.dropItem(selectedItem, items, player);
                    setUpItems(zones,items, player);
                    option = EXIT;
                    break;
                case EXIT:
                    break;
                default:
                    Strings.InputError();
            }

        } while (option != EXIT);


    }

    private static void movement(Player player, Zone[] zones) {
        validAnswer = false;
        Scanner scanner = new Scanner(System.in);
        do {
            Strings.MenuMovement();
            if (scanner.hasNextInt()) {
                int selected = scanner.nextInt() - 1;
                if (selected < 0 || selected > 3) {
                    Strings.InputError();
                } else {
                    player.GoTo(
                            selected,
                            zones[player.getIdZone() - 1].getDoors(),
                            zones[player.getIdZone() - 1].getDirections(),
                            zones[player.getIdZone() - 1].getAvailableZones()
                    );
                    validAnswer = true;
                }
            } else {
                Strings.InputError();
            }
        } while (!validAnswer);


    }

}
