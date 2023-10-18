package com.example.jocconversacionalalien.classes;

import java.util.ArrayList;

public class Zone {
    private String name;
    private int idZone;
    private boolean hasItem;
    private ArrayList<Item> items = new ArrayList<Item>();
    private boolean hasNpc;
    private boolean hasLight;
    private boolean[] doors = {false, false, false, false};
    private int[] directions = {-1, -1, -1, -1};
    private int[] availableZones = {0, 0, 0, 0};
    private boolean accessible;
    private boolean hasTraps;
    private String descriptionZone;


    static Item[] gameItems = ItemInitializer.setUpItems();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getAvailableZones() {
        return availableZones;
    }

    public void setAvailableZones(int[] availableZones) {
        this.availableZones = availableZones;
    }

    public String getDescriptionZone() {
        System.out.println(this.descriptionZone);
        return descriptionZone;
    }

    public void setDescriptionZone(String descriptionZone) {
        this.descriptionZone = descriptionZone;
    }


    private void openDoor() {
    }

    private void killPlayer() {
    }

    protected void useItem() {
    }

    public int getIdZone() {
        return idZone;
    }

    public void setIdZone(int idZone) {
        this.idZone = idZone;
    }

    public boolean isHasItem() {
        hasItem = false;
        for (Item item : gameItems) {
            if (item.getLocalization() == idZone) {
                hasItem = true;
                break;
            }

        }
        return hasItem;
    }

    public void setHasItem(boolean hasItem) {
        this.hasItem = hasItem;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public boolean isHasNpc() {
        return hasNpc;
    }

    public void setHasNpc(boolean hasNpc) {
        this.hasNpc = hasNpc;
    }

    public boolean isHasLight() {
        return hasLight;
    }

    public void setHasLight(boolean hasLight) {
        this.hasLight = hasLight;
    }

    public boolean[] getDoors() {
        return doors;
    }

    public void setDoors(boolean[] doors) {
        this.doors = doors;
    }

    public int[] getDirections() {
        return directions;
    }

    public void setDirections(int[] directions) {
        this.directions = directions;
    }

    public void setDirection(int door, int status) {
        directions[door] = status;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    public boolean isHasTraps() {
        return hasTraps;
    }

    public void setHasTraps(boolean hasTraps) {
        this.hasTraps = hasTraps;
    }

    public void printItems(){
        if(items== null){
            System.out.println("there is nothing in this room");
        }else{
            System.out.println("theres something on the ground");
            for (Item itemlist :items) {
                System.out.println(itemlist.getName());
            }
        }

    }

    public ArrayList<Item> addItems(){

                ArrayList<Item> itemsToReturn = new ArrayList<Item>();

         for(int i =0; i< gameItems.length;i++){
             if(gameItems[i].getLocalization() == idZone){
                 itemsToReturn.add(gameItems[i]);

             }
         }
        for (Item item : gameItems) {

        }
        return itemsToReturn;
    }
}
