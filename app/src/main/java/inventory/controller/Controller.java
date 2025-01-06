package inventory.controller;

import inventory.view.Popup;

import inventory.model.ClothingItem;
import inventory.model.HospitalFood;
import inventory.model.HospitalPatient;

import java.util.ArrayList;

import com.google.common.net.HostAndPort;

//todo - Reporting for each type
//    Min
//    Max
//    Average
//    Count
//    Discount

public class Controller {
   private Popup view;

   public Controller(){
      this.view = new Popup();
   }

   public void start(){
      view.displayMessage("Verify that files load!");
      ArrayList<ClothingItem> clothes = IOController.readClothingItemsFromFile("./ClothingItems.csv");
      view.displayMessage("Loaded " + clothes.size() + " items.");
   }

   /**
    * Applies a discount to a given type of clothing
    * @param clothingType The type of clothing
    * @param discount The discount to use
    * @param clothes The array of clothing to apply discount to
    */
   private void applyDiscountTo(String clothingType, double discount, ClothingItem[] clothes){
      for (ClothingItem currentClothingItem : clothes){
         if (currentClothingItem.getClothingType().equalsIgnoreCase(clothingType)){
            double currentPrice = currentClothingItem.getPrice();
            currentPrice = currentPrice - (currentPrice * discount);
            currentClothingItem.setPrice(currentPrice);
         }
      }
   }

   /**
    * Applies a discount to a given hospital food type
    * @param foodName Name of the food to search by
    * @param discount Discount to apply
    * @param hospitalFood The array of hospital food to apply discount to
    */
   private void applyDiscountTo(String foodName, double discount, HospitalFood[] hospitalFood){
      for (HospitalFood currentFood : hospitalFood){
         if (currentFood.getFoodName().equalsIgnoreCase(foodName)){
            double currentPrice = currentFood.getPrice();
            currentPrice = currentPrice - (currentPrice * discount);
            currentFood.setPrice(currentPrice);
         }
      }
   }

   /**
    * Applies a discount to the price of stay for patients in a certain age range.
    * @param minAge Minimum age of patients
    * @param maxAge Maximum age of patients
    * @param discount Discount to apply
    * @param hospitalPatients The array of hospital patients to apply discount to
    */
   private void applyDiscountTo(int minAge, int maxAge, double discount, HospitalPatient[] hospitalPatients){
      for (HospitalPatient currentPatient : hospitalPatients){
         if (currentPatient.getAge() >= minAge && currentPatient.getAge() <= maxAge){
            double currentPrice = currentPatient.getPriceOfStay();
            currentPrice = currentPrice - (currentPrice * discount);
            currentPatient.setPriceOfStay(currentPrice);
         }
      }
   }

}
