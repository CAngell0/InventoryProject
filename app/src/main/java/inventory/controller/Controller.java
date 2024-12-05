package inventory.controller;

import inventory.view.Popup;

import inventory.model.ClothingItem;
import inventory.model.HospitalFood;
import inventory.model.HospitalPatient;

import java.util.ArrayList;

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
      ArrayList<ClothingItem> discountedClothes = new ArrayList<ClothingItem>();
      for (int index = 0; index < clothes.length; index++){
         if (clothes[index].getClothingType().equalsIgnoreCase(clothingType)){
            discountedClothes.add(clothes[index]);
            discountedClothes.get(discountedClothes.size() - 1).setPrice(clothes[index].getPrice() * discount);
         }
      }

      ClothingItem[] returnedList = new ClothingItem[discountedClothes.size()];
      for (int index = 0; index < returnedList.length; index++){
         returnedList[index] = discountedClothes.get(index);
      }
      return returnedList;
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
    * Counts the amount of vegan foods in a given list of HosptialFood items
    * @param food Array of HostpitalFood
    * @return An integer count of hospital food that is vegan
    */
   private int countVeganFood(HospitalFood[] food){
      int count = 0;

      for (HospitalFood foodItem : food){
         if (foodItem.getIsVegan()) count++;
      }

      return count;
   }

   private int countPatientsInAgeRange(int minAge, int maxAge, HospitalPatient[] patients){
      int count = 0;
      
      for (HospitalPatient patient : patients){
         if (patient.getAge() >= minAge && patient.getAge() <= maxAge) count++;
      }

      return count;
   }
}
