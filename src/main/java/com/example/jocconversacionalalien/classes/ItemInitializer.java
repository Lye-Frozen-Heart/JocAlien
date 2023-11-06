package com.example.jocconversacionalalien.classes;


import java.util.Random;

public class ItemInitializer {

    //owner constants
    private static final int NO_OWNER = 0;
    private static final int PLAYER = 1;
    private static final int ALIEN = 2;
    private static final int NPC = 3;

    //Item id constants
    private static final int CARD = 0;
    private static final int NPC_CARD = 1;
    private static final int TOOL = 2;
    private static final int FLASHLIGHT = 3;
    public static final int SPACE_SUIT = 4;
    private static final int DONUT = 5;

    static Random random = new Random();

    public static Item[] setUpItems() {

        Item card = new Item();
        card.setItemId(CARD);
        card.setName("Card");
        card.setDescription("Its a card used to open rooms");
        card.setOwner(PLAYER);
        card.setLocalization(0);
        card.setStatus(false);

        Item npcCard = new Item();
        npcCard.setItemId(NPC_CARD);
        npcCard.setName("NPC Card");
        npcCard.setDescription("Its a card used to open rooms");
        npcCard.setOwner(NPC);
        npcCard.setLocalization(3);
        npcCard.setStatus(false);

        Item tool = new Item();
        tool.setItemId(TOOL);
        tool.setName("Tool");
        tool.setDescription("This tool can be used to repair the engine");
        tool.setOwner(PLAYER);
        tool.setLocalization(1);
        tool.setStatus(false);

        Item flashlight = new Item();
        flashlight.setItemId(FLASHLIGHT);
        flashlight.setName("Flashlight");
        flashlight.setDescription("You can't see anything? Try to turn it on");
        flashlight.setOwner(PLAYER);
        flashlight.setLocalization(random.nextInt(8) + 1); //random.nextInt(8) + 1
        flashlight.setStatus(false);

        Item spaceSuit = new Item();
        spaceSuit.setItemId(SPACE_SUIT);
        spaceSuit.setName("Space Suit");
        spaceSuit.setDescription("It's just a space suit, put it on, you might look pretty cool");
        spaceSuit.setOwner(PLAYER);
        spaceSuit.setLocalization(4);//4
        spaceSuit.setStatus(false);

        Item donut = new Item();
        donut.setItemId(DONUT);
        donut.setName("Donut");
        donut.setDescription("A Donut it looks delicious!");
        donut.setOwner(PLAYER);
        donut.setLocalization(5);//5
        donut.setStatus(false);

        return new Item[]{
                card, npcCard, tool, flashlight, spaceSuit,donut
        };
    }
}
