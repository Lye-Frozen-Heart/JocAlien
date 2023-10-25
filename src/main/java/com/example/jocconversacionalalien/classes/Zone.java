package com.example.jocconversacionalalien.classes;

import java.util.ArrayList;

public class Zone {
    private String name;
    private static int idZone;
    private boolean hasItem;
    private ArrayList<Item> items;
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
    public int[] getAvailableZones() {
        return availableZones;
    }
    public String getDescriptionZone() {
        System.out.println(this.descriptionZone);
        return descriptionZone;
    }
    public boolean hasItems() {
       boolean hasItems = true;
        if(items.size()==0){
            hasItems= false;
        }
        return hasItems;
    }
    public boolean isHasLight() {
        return hasLight;
    }
    public boolean[] getDoors() {
        return doors;
    }
    public int[] getDirections() {
        return directions;
    }

    public  int getIdZone() {return idZone;}

    public boolean isAccessible() {
        return accessible;
    }
    public boolean isHasTraps() {
        return hasTraps;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAvailableZones(int[] availableZones) {
        this.availableZones = availableZones;
    }
    public void setDescriptionZone(String descriptionZone) {
        this.descriptionZone = descriptionZone;
    }
    public void setIdZone(int idZone) {
        this.idZone = idZone;
    }
    public void setHasItem(boolean hasItem) {
        this.hasItem = hasItem;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    public void setHasNpc(boolean hasNpc) {
        this.hasNpc = hasNpc;
    }
    public void setHasLight(boolean hasLight) {
        this.hasLight = hasLight;
    }
    public void setDoors(boolean[] doors) {
        this.doors = doors;
    }
    public void setDirections(int[] directions) {
        this.directions = directions;
    }
    public void setDirection(int door, int status) {
        directions[door] = status;
    }
    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }
    public void setHasTraps(boolean hasTraps) {
        this.hasTraps = hasTraps;
    }

    public void printItems(){
        int itemPosition =1;
        if(items.toArray().length== 0){
            System.out.println("there is nothing in this room");
        }else{
            System.out.println("theres something on the ground");
            for (Item itemlist :items) {
                System.out.println(itemPosition + " - "+itemlist.getName());
                itemPosition++;
            }
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public static ArrayList<Item> addItems(Item[]items, int idZone){

                ArrayList<Item> itemsToReturn = new ArrayList<Item>();

         for(int i =0; i< items.length;i++){
             if(items[i].getLocalization() == idZone){
                 itemsToReturn.add(items[i]);
             }
         }
        return itemsToReturn;
    }
}
