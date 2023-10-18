package com.example.jocconversacionalalien.classes;

import java.util.Scanner;

public class Menus {
    static Scanner scanner = new Scanner(System.in);

    static int option = 0;
    static boolean validAnswer = false;



    public void LightOnMenu(Zone[] zones, Item[] items, Player player, ArtificialIntelligence iHall) {
        final int SPEAK_IHALL = 1;
        final int LOOK_DOORS = 2;
        final int LOOK_ITEMS = 3;
        final int OPEN_BACKPACK = 4;
        final int MOVE = 5;
        final int EXIT_GAME = 6;


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
            } while (!validAnswer);

            switch (option) {
                case SPEAK_IHALL:
                    SpeakIHall(items, zones, player, iHall);
                    break;
                case LOOK_DOORS:
                    player.LookAround(zones[player.getIdZone() - 1].getAvailableZones());
                    break;
                case LOOK_ITEMS:
                    zones[player.getIdZone()-1].printItems();
                    break;
                case OPEN_BACKPACK:
                    player.printItems();
                    break;
                case MOVE:
                    movement(player, zones);
                    zones[player.getIdZone() - 1].getDescriptionZone();
                    break;
                case EXIT_GAME:
                    Game.exitGame();
                    break;
                default:
                    Strings.InputError();
            }

        } while (option != EXIT_GAME);

    }

    public void SpeakIHall(Item[] items, Zone[] zones, Player player, ArtificialIntelligence iHall) {
        final int FLASHLIGHT_LOCATION = 1;
        final int ALIEN_LOCATION = 2;
        final int OPEN_DOOR = 3;
        final int HELP = 4;
        final int EXIT_IHALL = 5;
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
                    iHall.askForAlien();
                    Strings.NotImplemented();
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
                case EXIT_IHALL:
                    Strings.IHallExit();
                    break;
                default:
                    Strings.InputError();
            }
        } while (option != EXIT_IHALL);


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
