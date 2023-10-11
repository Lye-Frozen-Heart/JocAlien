package com.example.jocconversacionalalien.classes;

public class Player extends Character {

  private boolean infected = false;
  private boolean canBreath = true;
  private boolean suitWorn = false;
  private int idZone = 3;
  private   String[] arrayRoomNames= {"No Door", "Workshop", "Offices", "Machine Room",
  "Locker Room", "Kitchen", "Dinning Room", "Bedroom","Bathroom", "Exit"};
  private Item[]inventario = {};

  @Override
  protected void ToTake() {}

  @Override
  protected void GoTo(int imputDirection,boolean[] doors, int[] directions, int[]availableZones) {
    if(checkDoorsOpen(imputDirection, doors, directions)){
      setIdZone(availableZones[imputDirection]);
      ColorChanger.printTextToGreen("You just moved to the " + arrayRoomNames[availableZones[imputDirection]]);
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

  public void ToOpen(Item[]items, Zone[] zone,int actualZone, int door) {
    if (hasCard(items)){
      System.out.println("You successfully opened the door");

      zone[actualZone].setDirection( door,1);
    }else{
      System.out.println("You dont have the card to open de door");
    }
  }
  public void ToClose(Item[]items, Zone[] zone,int door) {
    if (hasCard(items)){
      System.out.println("You successfully closed the door");

      zone[0].setDirection( door,-1);
    }else{
      System.out.println("You dont have the card to open de door");
    }
  }

  /**
   * 
   */
  public void LookAround(int[]availableZones){
    ColorChanger.printTextToGreen("You look around...Directions you can see:" +
    "\nHeading North: " + arrayRoomNames[availableZones[0]] + "\nTilting East: " + arrayRoomNames[availableZones[1]] +
    "\nBacking South: " + arrayRoomNames[availableZones[2]] + "\nAnd tilting out to West: " + arrayRoomNames[availableZones[3]]);
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
}


