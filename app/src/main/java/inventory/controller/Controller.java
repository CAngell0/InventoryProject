package inventory.controller;

import inventory.view.Popup;

import inventory.model.ClothingItem;

public class Controller {
   private Popup view;

   public Controller(){
      this.view = new Popup();
   }

   public void start(){
      System.out.println("Hello World!");
   }

   private void applyDiscountTo(String clothingType, double discount, ClothingItem[] clothes){
      for (int index = 0; index < clothes.length; index++){
         if (clothes[index].getClothingType() == clothingType){
            double currentPrice = clothes[index].getPrice();
            clothes[index].setPrice(currentPrice * discount);
         }
      }
   }
}
