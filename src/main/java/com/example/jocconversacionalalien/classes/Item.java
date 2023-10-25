package com.example.jocconversacionalalien.classes;

public class Item {
  private int itemId;
  private String name;
  private String description;
  private int localization;
  private int owner;


  public void setItemId(int itemId){
    this.itemId = itemId;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public void setLocalization(int localization) {
    this.localization = localization;
  }
  public void setOwner(int owner) {
    this.owner = owner;
  }

  public int getItemId() {
    return itemId;
  }
  public String getName() {
    return name;
  }
  public String getDescription() {
    return description;
  }
  public int getLocalization() {
    return localization;
  }
  public int getOwner() {
    return owner;
  }

  public void useDonut(Item[] items,int itemSelected,Player player, Enemy alien){
    if(player.getIdZone()==alien.getIdZone()){
      items[itemSelected].setOwner(2);
      items[itemSelected].setLocalization(0);
    }else{
      items[itemSelected].setOwner(0);
      items[itemSelected].setLocalization(0);
    }

  }
  public void useFlashlight(Player player){
    if(player.isFlashlightOn()){
      player.setFlashlightOn(false);
    }else{
      player.setFlashlightOn(true);
    }
  }
  public void useTool(Player player, Enemy alien){
    if(player.getIdZone()==alien.getIdZone()){
      player.setInfected(true);
      alien.setAsleep(true);
    }else if(player.getIdZone() == 9){
      System.out.println("you opened the final door finally you are free");

    }
    else{
      Strings.NoInteracton();
    }
  }
  public void useSpaceSuit(Player player){
    if (player.getSuitWorn()) {
      player.setSuitWorn(false);
    }else{
      player.setSuitWorn(true);
    }
  }
  public void useCard(){
    Strings.UseCard();
  }

  public void setStatus(boolean b) {
  }
}
