package inventory.controller.typeManipulation;

import inventory.model.HospitalFood;

public class HospitalFoodHelpers {

   /**
    * Count the amount of food that matches a specific food type
    * @param foodName The name of the food to query by
    * @param food The array of hospital food items to search in
    * @return A count of how many food items of that type are in the array
    */
   public int countFoodType(String foodName, HospitalFood[] food){
      int count = 0;

      for (HospitalFood foodItem : food){
         if (foodItem != null && foodItem.getFoodName().equalsIgnoreCase(foodName)) count++;
      }

      return count;
   }

   /**
    * Gets the average price of all food from a specified HospitalFood array
    * @param food The array to calculate an average from
    * @return An average price
    */
   public double getAverageFoodPrice(HospitalFood[] food){
      if (food.length == 0) return 0.0;
      double average = 0.0;

      for (HospitalFood item : food) {
         if (item != null) average += item.getPrice();
      }
      average = average / food.length;

      return average;
   }

   /**
    * Gets the smallest price of the items in a given HospitalFood array
    * @param food The array to get the minimum price from
    * @return The minimum price
    */
   public double getMinFoodPrice(HospitalFood[] food){
      if (food.length == 0) return 0.0;
      double min = Double.MAX_VALUE;

      for (HospitalFood item : food){
         if (item != null && item.getPrice() < min) min = item.getPrice();
      }

      return min;
   }
   
   /**
    * Gets the largest price of the items in a given HospitalFood array
    * @param food The array to get the maximum price from
    * @return The maximum price
    */
   public double getMaxFoodPrice(HospitalFood[] food){
      if (food.length == 0) return 0.0;
      double max = Double.MIN_VALUE;

      for (HospitalFood item : food){
         if (item != null && item.getPrice() > max) {
            max = item.getPrice();
         }
      }

      return max;
   }
}
