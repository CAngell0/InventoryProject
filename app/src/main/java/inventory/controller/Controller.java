package inventory.controller;

import inventory.view.Popup;

import inventory.model.ClothingItem;
import inventory.model.HospitalFood;
import inventory.model.HospitalPatient;

import inventory.controller.typeManipulation.ClothingHelpers;
import inventory.controller.typeManipulation.HospitalFoodHelpers;
import inventory.controller.typeManipulation.HospitalPatientHelpers;

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

   private ClothingHelpers clothingHelper;
   private HospitalFoodHelpers hospitalFoodHelper;
   private HospitalPatientHelpers hospitalPatientHelper;

   public Controller(){
      this.view = new Popup();
      this.clothingHelper = new ClothingHelpers();
      this.hospitalFoodHelper = new HospitalFoodHelpers();
      this.hospitalPatientHelper = new HospitalPatientHelpers();
   }

   public void start(){
      view.displayMessage("Verify that files load!");
      // ArrayList<ClothingItem> clothes = IOController.readClothingItemsFromFile("./ClothingItems.csv");
      ArrayList<HospitalPatient> clothes = IOController.readHospitalPatientsFromFile("./HospitalPatients.csv");
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

   /**
    * Gathers a handful of different types of information about a given ClothingItem array.
    * This method reports the minimum price, maximum price, and average price.
    * Along with a count of a specific type of clothing.
    * @param clothingType The type of clothing to count and include in the report
    * @param clothes An array/list of clothes
    * @return A string report of all the information listed
    */
   private String reportClothingItems(String clothingType, ClothingItem[] clothes){
      double maxPrice = clothingHelper.getMaxClothingPrice(clothes);
      double minPrice = clothingHelper.getMinClothingPrice(clothes);
      double averagePrice = clothingHelper.getAverageClothingPrice(clothes);
      int typeCount = clothingHelper.countClothingType(clothingType, clothes);

      String report = (
         "In the clothing inventory, the highest price is " + maxPrice +
         "\nIn the clothing inventory, the lowest price is " + minPrice +
         "\nIn the clothing inventory, the average price is " + averagePrice +
         "\nThere are a total of " + typeCount + " " + clothingType + " in the clothing inventory"
      );

      return report;
   }

   /**
    * Gathers a handful of different types of information about a given HospitalFood array.
    * This method reports the minimum price, maximum price, and average price.
    * Along with a count of a specific type of food.
    * @param foodType The type of food to count and include in the report
    * @param food An array/list of hospital food
    * @return A string report of all the information listed
    */
    private String reportFoodItems(String foodType, HospitalFood[] food){
      double maxPrice = hospitalFoodHelper.getMaxFoodPrice(food);
      double minPrice = hospitalFoodHelper.getMinFoodPrice(food);
      double averagePrice = hospitalFoodHelper.getAverageFoodPrice(food);
      int typeCount = hospitalFoodHelper.countFoodType(foodType, food);

      String report = (
         "In the hospital food inventory, the highest price is " + maxPrice +
         "\nIn the hospital food inventory, the lowest price is " + minPrice +
         "\nIn the hospital food inventory, the average price is " + averagePrice +
         "\nThere are a total of " + typeCount + " " + foodType + " in the hospital food inventory"
      );

      return report;
   }

   /**
    * Gathers a handful of different types of information about a given HospitalPatient array.
    * This method reports the minimum, maximum, and average price of stay.
    * Along with a count of patients in a specific age range.
    * @param minAge The minimum age for the specified age range
    * @param maxAge The maximum age for the specified age range
    * @param patients An array/list of hospital patients
    * @return A string report of all the information listed
    */
    private String reportPatientItems(int minAge, int maxAge, HospitalPatient[] patients){
      double maxPrice = hospitalPatientHelper.getMaxPriceOfStay(patients);
      double minPrice = hospitalPatientHelper.getMinPriceOfStay(patients);
      double averagePrice = hospitalPatientHelper.getAveragePriceOfStay(patients);
      int ageCount = hospitalPatientHelper.countPatientsInAgeRange(minAge, maxAge, patients);

      String report = (
         "Across all patients, the highest price of stay is " + maxPrice +
         "\nAcross all patients, the lowest price of stay is " + minPrice +
         "\nAcross all patients, the average price of stay is " + averagePrice +
         "\nThere are a total of " + ageCount + " people between the age of " + minAge + " and " + maxAge + " across all patients"
      );

      return report;
   }
}
