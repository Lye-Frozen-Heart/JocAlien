package com.example.jocconversacionalalien.classes;

import java.util.Scanner;

public class Game {


    static Zone[] zones = {};
    static Item[] items = {};
    static Player player;
    static Enemy alien;
    static NonPlayableCharacter npc;

    static {
        player = new Player();
        alien = new Enemy();
        npc = new NonPlayableCharacter();
        npc.setIdZone(ZoneInitializer.BEDROOM);
        player.setInventory(player.addItemsInventory());
    }

    static Menus menus = new Menus();

    static ArtificialIntelligence iHall = new ArtificialIntelligence();



    public static void startGame() {

        Strings.GameIntroduction();

        //initialize
        zones = ZoneInitializer.setUpZones();
        items = ItemInitializer.setUpItems();

        //Start Game

        final int START_GAME = 1;
        final int CREDITS = 2;
        final int EXIT_GAME = 3;

        boolean validAnswer = false;
        int option = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            do {
                validAnswer = false;
                Strings.MenuInitGame();
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    validAnswer = true;
                } else {
                    Strings.InputError();
                }
            } while (!validAnswer);
            switch (option) {
                case START_GAME:
                    menus.LightOnMenu(zones, items, player, iHall,alien,npc);
                    break;
                case CREDITS:
                    Strings.Credits();
                    break;
                case EXIT_GAME:
                    Game.exitGame();
                    break;
                default:
                    Strings.InputError();
            }
        } while (option != EXIT_GAME);
    }


    private void pauseGame() {
        //TODO
    }

    private void restartGame() {
        //TODO
    }

    public static void exitGame() {
        System.exit(0);
    }

    //TODO                        /////////////////////////////////
    //TODO                       //            WORKSHOP     1    //
    //TODO         /////////////////////                      ///////////////////////
    //TODO         ||                  |                      |                     ||
    //TODO         ||    LOCKER  4             OFFICES    2           BATHROOM 8    ||
    //TODO         ||                  |                     |                      ||
    //TODO         ||/////      //////////////      /////////////////       ////////||
    //TODO         ||                  |      MACHINE        |                      ||
    //TODO         ||                  |       ROOM       3  |                      ||
    //TODO         ||////        /////////////////////////////////////     /////////||
    //TODO         ||                  |                     |                      ||
    //TODO         ||     KITCHEN  5          DINNING   6            BEDROOM 7      ||
    //TODO         ||                  |        ROOM         |                      ||
    //TODO        /////////////////////////////    /////////////////////////////////||
    //TODO                                    EXIT 9


    public static void main(String[] args) {
        startGame();
    }
}
