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
      alien.setAsleep(true);
      Strings.AlienEatDonut();
    }else{
      items[itemSelected].setOwner(0);
      items[itemSelected].setLocalization(0);
      Strings.EatDonut();
    }

  }
  public void useFlashlight(Player player){
    if(player.isFlashlightOn()){
      player.setFlashlightOn(false);
      System.out.println("You turned off the flashlight");
    }else{
      player.setFlashlightOn(true);
      System.out.println("You turned on the flashlight");
    }
  }
  public void useTool(Player player, Enemy alien){
    if(player.getIdZone()==alien.getIdZone()&& !alien.isAsleep()){
      player.setInfected(true);
      alien.setAsleep(true);
      System.out.println("You hit hard the alien with the tool");

    }else if(player.getIdZone() == 9){
      System.out.println("You opened the final door finally you are free");
      Strings.EndGame();
      Game.exitGame();

    }
    else{
      Strings.NoInteracton();
    }
  }
  public void useSpaceSuit(Player player){
    if (player.getSuitWorn()) {
      player.setSuitWorn(false);
      System.out.println("Suit off");
    }else{
      player.setSuitWorn(true);
      System.out.println("Suit on");
    }
  }
  public void useCard(){
    Strings.UseCard();
  }

  public void setStatus(boolean b) {
  }
}
