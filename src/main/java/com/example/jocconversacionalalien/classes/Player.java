package com.example.jocconversacionalalien.classes;

public class Player extends Character {

  private boolean infected = false;
  private boolean canBreath = true;
  private boolean suitWorn = false;
  private int idZone = 3;
  private   String[] arrayRoomNames= {"No Door", "Workshop", "Offices", "Machine Room",
  "Locker Room", "Kitchen", "Dinning Room", "Bedroom","Bathroom", "Exit"};
  

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

  private void ToOpen() {}

  private void ToClose() {}

  /**
   * 
   */
  public void LookAround(int[]availableZones){
    ColorChanger.printTextToGreen("You look around...Directions you can see: Heading North: " + arrayRoomNames[availableZones[0]] + " Tilting East: The " + arrayRoomNames[availableZones[1]] + " Backing South: The " + arrayRoomNames[availableZones[2]] + " And tilting out to West: " + arrayRoomNames[availableZones[3]]);
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
}
