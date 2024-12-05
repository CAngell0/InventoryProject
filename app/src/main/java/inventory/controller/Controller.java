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

   /**
    * Applies a discount to a given type of clothing
    * @param clothingType The type of clothing
    * @param discount The discount to use
    * @param clothes The array of clothing to apply discount to
    * @return The newly discounted array of ClothesItem
    */
   private ClothingItem[] applyDiscountTo(String clothingType, double discount, ClothingItem[] clothes){
      for (ClothingItem item : clothes){
         if (item.getClothingType().equals(clothingType)){
            double currentPrice = item.getPrice();
            item.setPrice(currentPrice * discount);
         }
      }
      return clothes;
   }
}
