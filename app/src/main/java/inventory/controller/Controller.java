package inventory.controller;

import inventory.view.Popup;

import inventory.model.ClothingItem;
import inventory.model.HospitalFood;
import inventory.model.HospitalPatient;

import java.util.ArrayList;

import com.google.common.net.HostAndPort;

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
    */
   private void applyDiscountTo(String clothingType, double discount, ClothingItem[] clothes){
      for (ClothingItem currentClothingItem : clothes){
         if (currentClothingItem.getClothingType().equalsIgnoreCase(clothingType)){
            double currentPrice = currentClothingItem.getPrice();
            currentPrice = currentPrice * discount;
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
            currentPrice = currentPrice * discount;
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
            currentPrice = currentPrice * discount;
            currentPatient.setPriceOfStay(currentPrice);
         }
      }
   }

   /**
    * Counts the amount of clothe items that are of a specific type
    * @param type The type to search by
    * @param clothes Array of clothes
    * @return An integer count of the clothing type
    */
   private int countClothingType(String type, ClothingItem[] clothes){
      int count = 0;
      for (ClothingItem item: clothes){
         if (item.getClothingType().equalsIgnoreCase(type)) count++;
      }
      return count;
   }

   /**
    * Count the amount of food that matches a specific food type
    * @param foodName The name of the food to query by
    * @param food The array of hospital food items to search in
    * @return A count of how many food items of that type are in the array
    */
   private int countFoodType(String foodName, HospitalFood[] food){
      int count = 0;

      for (HospitalFood foodItem : food){
         if (foodItem.getFoodName().equalsIgnoreCase(foodName)) count++;
      }

      return count;
   }

   /**
    * Count the amount of patients in a certain age range
    * @param minAge The minimum age to search by
    * @param maxAge The maximum age to search by
    * @param patients The array of patients to search in
    * @return A count of patients that are within the designated age range
    */
   private int countPatientsInAgeRange(int minAge, int maxAge, HospitalPatient[] patients){
      int count = 0;
      
      for (HospitalPatient patient : patients){
         if (patient.getAge() >= minAge && patient.getAge() <= maxAge) count++;
      }

      return count;
   }
}
