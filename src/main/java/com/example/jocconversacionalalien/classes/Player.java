package com.example.jocconversacionalalien.classes;

public class Player extends Character {

  private boolean infected = false;
  private boolean canBreath = true;
  private boolean suitWorn = false;
  private int idZone = 3;
  private   String[] arrayRoomNames= {"no Door", "Workshop", "Ofices", "Machine Room",
  "Locker", "kitchen", "dining Room", "bedroom","bathroom", "exit"};
  private Item[] inventario ={};

  @Override
  protected void ToTake() {}

  @Override
  protected void GoTo(int imputDirection,boolean[] doors, int[] directions, int[]availableZones) {
    if(checkDoorsOpen(imputDirection, doors, directions)){
      setIdZone(availableZones[imputDirection]);
      System.out.println("you just moved to t " + arrayRoomNames[availableZones[imputDirection]] );
    }
    
  }

  /**
   * @param idZone
   */
  @Override
  protected void CheckZone(int idZone) {
    setIdZone(idZone);
  }

  private void ToLeaveItem() {}

  private void ToPowerOff() {}

  private void ToPowerOn() {}

  private void ToUseXItem() {}

  private void ObtainInfectionProgress() {}

  private void ConsiderNPC() {}

  private void ToTalk() {}

  private void ToOpen(Item[]items, Zone[] zone,int door) {
    if (hasCard(items)){
      System.out.println("you succesfully opened the door");

      zone[0].setDirection( door,1);
    }else{
      System.out.println("you dont have the card to open de door");
    }
  }


  private void ToClose(Item[]items, Zone[] zone,int door) {
    if (hasCard(items)){
      System.out.println("you succesfully opened the door");

      zone[0].setDirection( door,-1);
    }else{
      System.out.println("you dont have the card to open de door");
    }
  }

  /**
   * 
   */
  public void LookAround(int[]availableZones){
    System.out.println("you look around and can see that: going north " + arrayRoomNames[availableZones[0]] + " going east " + arrayRoomNames[availableZones[1]] + " going south " + arrayRoomNames[availableZones[2]] + " and going west " + arrayRoomNames[availableZones[3]]);
  }

  public boolean getInfected() {
    return infected;
  }

  public boolean getCanBreath() {
    return canBreath;
  }

  public boolean getSuitWorn() {
    return suitWorn;
  }

  public  int getIdZone() {
    return idZone;
  }

  public void setInfected(boolean infected) {
    this.infected = infected;
  }

  public void setCanBreath(boolean canBreath) {
    this.canBreath = canBreath;
  }

  public void setSuitWorn(boolean suitWorn) {
    this.suitWorn = suitWorn;
  }

  public void setIdZone(int idZone) {
    this.idZone = idZone;
  }
  public boolean checkDoorsOpen(int imputDirection,boolean[] doors, int[] directions) {
    boolean canMove = false;
    if(doors[imputDirection]){
      if(directions[imputDirection]==1){
        canMove=true;
      }else{
        System.out.println("the door is closed");
      }

    }else{
      System.out.println("there is no door there");
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
}


