package com.example.jocconversacionalalien.classes;

import java.util.ArrayList;

public class Player extends Character {

  private boolean infected = false;
  private boolean canBreath = true;
  private boolean suitWorn = false;
  private boolean flashlightOn= false;
  private int idZone = 3;
  private ArrayList<Item> inventory = new ArrayList<>();
  private final String[] arrayRoomNames= {"No Door", "Workshop", "Offices", "Machine Room",
  "Locker Room", "Kitchen", "Dinning Room", "Bedroom","Bathroom", "Exit"};

  @Override
  protected void GoTo(int imputDirection,boolean[] doors, int[] directions, int[]availableZones) {
    if(checkDoorsOpen(imputDirection, doors, directions)){
      setIdZone(availableZones[imputDirection]);
      ColorChanger.printTextToGreen("You just moved to the " + arrayRoomNames[availableZones[imputDirection]]);
    }
    
  }


  @Override
  protected void CheckZone(int idZone) {
    setIdZone(idZone);
  }


  public void ToOpen(Item[]items, Zone[] zone,int actualZone, int door) {
    if (hasCard(items)){
      System.out.println("You successfully opened the door");

      zone[actualZone].setDirection( door,1);
    }else{
      System.out.println("You dont have the card to open de door");
    }
  }

  public boolean getSuitWorn() {
    return suitWorn;
  }
  public  int getIdZone() {
    return idZone;
  }
  public boolean isFlashlightOn() {
    return flashlightOn;
  }

  public void setInventory(ArrayList<Item> inventory) {
    this.inventory = inventory;
  }
  public void setInfected(boolean infected) {
    this.infected = infected;
  }
  public void setSuitWorn(boolean suitWorn) {
    this.suitWorn = suitWorn;
  }
  public void setIdZone(int idZone) {
    this.idZone = idZone;
  }
  public void setFlashlightOn(boolean flashlightOn) {
    this.flashlightOn = flashlightOn;
  }


  public void ToClose(Item[]items, Zone[] zone,int door) {
    if (hasCard(items)){
      System.out.println("You successfully closed the door");

      zone[0].setDirection( door,-1);
    }else{
      System.out.println("You dont have the card to open de door");
    }
  }
  public void LookAround(int[]availableZones){
    ColorChanger.printTextToGreen("You look around...Directions you can see:" +
    "\nHeading North: " + arrayRoomNames[availableZones[0]] + "\nTilting East: " + arrayRoomNames[availableZones[1]] +
    "\nBacking South: " + arrayRoomNames[availableZones[2]] + "\nAnd tilting out to West: " + arrayRoomNames[availableZones[3]]);
  }
  public boolean checkDoorsOpen(int imputDirection, boolean[] doors, int[] directions) {
    boolean canMove = false;
    if(doors[imputDirection]){
      if(directions[imputDirection]==1){
        canMove=true;
      }else{
        ColorChanger.printTextToRed("Door's Closed");
      }

    }else{
      ColorChanger.printTextToBlue("There is no door there");
    }
    return canMove;
  }

  public boolean hasCard(Item[] items) {
    boolean card = false;
    if(items[0].getOwner()== 1){
      card = true;
    }
    return card;
  }
  public void printItems(){
    int num =1;
    if(inventory.isEmpty()){
      System.out.println("you have nothing in your inventory");
    }else{
      System.out.println("you have ");
      for (Item items :inventory) {
        System.out.println(num+ " - "+items.getName());
        num++;
      }
    }

  }
  public ArrayList<Item> addItemsInventory(){

    ArrayList<Item> itemsToReturn = new ArrayList<Item>();

    for(int i =0; i< Game.items.length;i++){
      if(Game.items[i].getOwner() == 1){
        itemsToReturn.add(Game.items[i]);
      }
    }
    return itemsToReturn;
  }
  public void dropItem(int inventoryPosition, Item[] gameItems, Player player){
    int itemId = inventory.get(inventoryPosition -1).getItemId();
    gameItems[itemId].setOwner(0);
    gameItems[itemId].setLocalization(player.getIdZone());
    Strings.ItemDropped(arrayRoomNames[player.getIdZone()-1]);
  }
  public void getItemDescription(int inventoryPosition, Item[] gameItems){
    int itemId = inventory.get(inventoryPosition-1).getItemId();
    String description = gameItems[itemId].getDescription();
      System.out.println(description);
  }
}


