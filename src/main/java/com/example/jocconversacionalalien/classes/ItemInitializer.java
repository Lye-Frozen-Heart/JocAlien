package com.example.jocconversacionalalien.classes;


public class ItemInitializer {

    //owner constants
    private static final int NO_OWNER =0;
    private static final int PLAYER =1;
    private static final int ALIEN=2;
    private static final int NPC=3;
    public static Item[] setUpItems() {

        Item card = new Item();
        card.setName("Card");
        card.setDescription("Its a card used to open rooms");
        card.setOwner(PLAYER);
        card.setLocalization("");
        card.setStatus(false);

        Item[] itemsToReturn = new Item[]{
                card
        };
        return itemsToReturn;
    }
}
