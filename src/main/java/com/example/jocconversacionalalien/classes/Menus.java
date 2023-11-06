package com.example.jocconversacionalalien.classes;

import java.util.Scanner;

public class Menus {
    static Scanner scanner = new Scanner(System.in);
    static Item item = new Item();
    static int option = 0;
    static int shift = 0;
    static int infectedCount = 0;
    static boolean validAnswer = false;

    private static void setUpItems(Zone[] zones, Item[] items, Player player) {
        player.setInventory(player.addItemsInventory());

        zones[player.getIdZone() - 1].setItems(Zone.addItems(items, player.getIdZone()));
    }

    public static Zone currentZone(Player player, Zone[] zones) {
        Zone currentZone = null;

        for (Zone zone : zones
        ) {
            if (zone.getIdZone() == player.getIdZone()) {
                currentZone = zone;
            }

        }

        return currentZone;
    }

    public void LightOnMenu(Zone[] zones, Item[] items, Player player, Enemy alien, NonPlayableCharacter npc, ArtificialIntelligence iHall) {
        final int SPEAK_IHALL = 1;
        final int LOOK_DOORS = 2;
        final int LOOK_ITEMS = 3;
        final int OPEN_BACKPACK = 4;
        final int MOVE = 5;
        final int OPEN_MAP = 6;
        final int EXIT_GAME = 7;

        currentZone(player, zones).getDescriptionZone();

        do {
            AlienAction(alien, player);
            NpcAction(npc, player);

            do {
                validAnswer = false;
                Strings.MenuLightOnOptions();
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    validAnswer = true;
                } else {
                    Strings.InputError();
                }
            } while (!validAnswer);

            switch (option) {
                case SPEAK_IHALL:
                    SpeakIHall(items, zones, player, iHall, alien, npc);
                    shift++;
                    break;
                case LOOK_DOORS:
                    if(currentZone(player, zones).isHasLight()|| player.isFlashlightOn()){
                        player.LookAround(currentZone(player, zones).getAvailableZones());
                    }else{
                        Strings.noLight(items);
                    }

                    shift++;
                    break;
                case LOOK_ITEMS:
                    if(currentZone(player, zones).isHasLight()|| player.isFlashlightOn()){
                        currentZone(player, zones).printItems();
                        if (currentZone(player, zones).hasItems()) {
                            pickUpItemMenu(zones, player, items);
                            setUpItems(zones, items, player);
                        }
                        if(npc.getIdZone()==player.getIdZone()&& items[1].getOwner()==3){
                            Strings.askingNpcForTheCard();
                            items[1].setOwner(1);
                            items[1].setLocalization(0);
                            setUpItems(zones,items,player);
                        }
                    }else{
                        Strings.noLight(items);
                    }

                    shift++;
                    break;
                case OPEN_BACKPACK:
                    player.printItems();
                    if (!player.getInventory().isEmpty()) {
                        backpackItemSelection(items, player, alien, zones);
                    }
                    shift++;
                    break;
                case MOVE:
                    movement(player, zones);

                    shift++;
                    break;
                case OPEN_MAP:
                    Strings.PrintMap();

                    break;
                case EXIT_GAME:
                    Strings.EndGame();
                    Game.exitGame();
                    break;
                default:
                    Strings.InputError();
            }
            if (alien.getIdZone() == player.getIdZone()) {
                if (alien.isAsleep()) {
                    Strings.NoThreat();

                } else if (alien.isKnocked()) {
                    player.setInfected(true);
                } else {
                    Strings.AlienKillsYou();
                    Strings.EndGame();
                    Game.exitGame();
                }
            }

            if (player.isInfected()) {
                infectedCount++;
                if (infectedCount == 3) {
                    Strings.Infected();
                    Strings.EndGame();
                    Game.exitGame();
                }
            }

        } while (option != EXIT_GAME);

    }

    private void pickUpItemMenu(Zone[] zones, Player player, Item[] items) {
        do {
            validAnswer = false;
            Strings.MenuPickUpItem();
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option > 0 && option < zones[player.getIdZone() - 1].getItems().size() + 1) {
                    validAnswer = true;
                } else {
                    Strings.InputError();
                }
            } else {
                Strings.InputError();
            }
        } while (!validAnswer);
        player.pickUpItem(option, items, player, zones);

    }

    public void SpeakIHall(Item[] items, Zone[] zones, Player player, ArtificialIntelligence iHall, Enemy alien, NonPlayableCharacter npc) {

        final int HELP = 1;
        final int OPEN_DOOR = 2;
        final int EXIT_IHALL = 3;
        do {
            do {
                validAnswer = false;
                Strings.menuIHall();
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    validAnswer = true;
                } else {
                    Strings.InputError();
                }
            } while (!validAnswer);
            switch (option) {

                case OPEN_DOOR:
                    do {
                        validAnswer = false;
                        Strings.MenuOpenDoor();
                        if (scanner.hasNextInt()) {
                            int direction = scanner.nextInt();
                            if (direction > 0 && direction < 5) {
                                validAnswer = true;
                                if (player.getIdZone() != 9) {
                                    player.ToOpen(items, zones, player.getIdZone() - 1, direction - 1);
                                } else {
                                    if (items[1].getOwner() == 1) {
                                        player.ToOpen(items, zones, player.getIdZone() - 1, direction - 1);
                                    } else {
                                        Strings.IncorrectCard();
                                    }
                                }

                                option = EXIT_IHALL;
                            } else {
                                Strings.InputError();
                            }
                        } else {
                            Strings.InputError();
                        }
                    } while (!validAnswer);
                    break;
                case HELP:
                    iHallHelpMenu(zones, npc, iHall, alien);
                    break;

                case EXIT_IHALL:
                    Strings.IHallExit();
                    break;
                default:
                    Strings.InputError();
            }
        } while (option != EXIT_IHALL);
    }

    private static void iHallHelpMenu(Zone[] zones, NonPlayableCharacter npc, ArtificialIntelligence iHall, Enemy alien) {
        final int GENERAL_HELP = 1;
        final int FLASHLIGHT_LOCATION = 2;
        final int ALIEN_LOCATION = 3;
        final int NPC_LOCATION = 4;
        final int HOW_OPEN_DOORS = 5;
        final int WHERE_IS_CARD = 6;
        final int EXIT = 7;

        boolean askedOpeningDoors = false;
        do {
            do {
                validAnswer = false;
                Strings.menuHelpIhall(askedOpeningDoors);
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    validAnswer = true;
                } else {
                    Strings.InputError();
                }
            } while (!validAnswer);

            switch (option) {
                case GENERAL_HELP:
                    Strings.generalHelp();
                    break;
                case FLASHLIGHT_LOCATION:
                    Strings.IHallFlashlightLocation(iHall.askForFlashlight());
                    break;
                case ALIEN_LOCATION:
                    iHall.askForAlien(zones, alien);
                    break;
                case NPC_LOCATION:
                    iHall.askForNpc(zones, npc);
                    break;
                case HOW_OPEN_DOORS:
                    Strings.howToOpenDoors();
                    askedOpeningDoors = true;
                    break;
                case WHERE_IS_CARD:
                    if (askedOpeningDoors) {
                        Strings.whereIsTheCard();
                    } else {
                        Strings.InputError();
                    }
                    break;
                case EXIT:
                    Strings.IHallExit();
                    break;
                default:
                    Strings.InputError();
            }

        } while (option != EXIT);

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
                            setUpItems(zones, items, player);
                            break;
                    }
                    option = EXIT;
                    break;
                case DROP_ITEM:
                    player.dropItem(selectedItem, items, player);
                    setUpItems(zones, items, player);
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
                    player.MoveTo(
                            selected,
                            currentZone(player, zones).getDoors(),
                            currentZone(player, zones).getDirections(),
                            currentZone(player, zones).getAvailableZones(), player, zones
                    );
                    validAnswer = true;
                }
            } else {
                Strings.InputError();
            }
        } while (!validAnswer);


    }

    public void AlienAction(Enemy alien, Player player) {
        alien.pairShift(shift);
        if (alien.getIdZone() == player.getIdZone() && !alien.isAsleep()) Strings.AlienIsHere();
    }

    public void NpcAction(NonPlayableCharacter npc, Player player) {
        npc.fourthShift(shift);
        if (npc.getIdZone() == player.getIdZone()) Strings.NpcIsHere();
    }

}
