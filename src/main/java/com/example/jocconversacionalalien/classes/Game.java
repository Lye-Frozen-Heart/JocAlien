package com.example.jocconversacionalalien.classes;

import java.util.Scanner;

public class Game {


    static Zone[] zones = {};
    static Item[] items = {};
    static Player player = new Player();
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
                    menus.LightOnMenu(zones, items, player, iHall);
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
    //TODO                       //            WORKSHOP         //
    //TODO         /////////////////////                      ///////////////////////
    //TODO         ||                  |                      |                     ||
    //TODO         ||    DRESSER                OFFICES               BATHROOM      ||
    //TODO         ||                  |                     |                      ||
    //TODO         ||/////      //////////////      /////////////////       ////////||
    //TODO         ||                  |      MACHINE        |                      ||
    //TODO         ||                  |       ROOM          |                      ||
    //TODO         ||////        /////////////////////////////////////     /////////||
    //TODO         ||                  |                     |                      ||
    //TODO         ||     KITCHEN           DINNING                BEDROOM          ||
    //TODO         ||                  |     ROOM            |                      ||
    //TODO        /////////////////////////////    /////////////////////////////////||
    //TODO                                    EXIT


    public static void main(String[] args) {
        startGame();
    }
}
