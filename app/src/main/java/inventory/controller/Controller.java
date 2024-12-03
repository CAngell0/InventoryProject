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
      for (ClothingItem item : clothes){
         if (item.getClothingType().equals(clothingType)){
            double currentPrice = item.getPrice();
            item.setPrice(currentPrice * discount);
         }
      }
   }
}
