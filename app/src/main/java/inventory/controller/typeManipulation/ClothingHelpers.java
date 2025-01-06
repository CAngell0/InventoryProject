package inventory.controller.typeManipulation;

import inventory.model.ClothingItem;

public class ClothingHelpers {

   /**
    * Counts the amount of clothe items that are of a specific type
    * @param type The type to search by
    * @param clothes Array of clothes
    * @return An integer count of the clothing type
    */
   public int countClothingType(String type, ClothingItem[] clothes){
      int count = 0;
      for (ClothingItem item: clothes){
         if (item.getClothingType().equalsIgnoreCase(type)) count++;
      }
      return count;
   }

   /**
    * Gets the average price of all clothes from a specified ClothingItem array
    * @param clothes The array to calculate an average from
    * @return An average price
    */
   public double getAverageClothingPrice(ClothingItem[] clothes){
      if (clothes.length == 0) return 0.0;
      double average = 0.0;

      for (ClothingItem item : clothes) {
         if (item != null) average += item.getPrice();
      }
      average = average / clothes.length;

      return average;
   }

   /**
    * Gets the smallest price of the items in a given ClothingItem array
    * @param clothes The array to get the minimum price from
    * @return The minimum price
    */
   public double getMinClothingPrice(ClothingItem[] clothes){
      if (clothes.length == 0) return 0.0;
      double min = Double.MAX_VALUE;

      for (ClothingItem item : clothes){
         if (item != null && item.getPrice() < min) min = item.getPrice();
      }

      return min;
   }
   
   /**
    * Gets the largest price of the items in a given ClothingItem array
    * @param clothes The array to get the maximum price from
    * @return The maximum price
    */
   public double getMaxClothingPrice(ClothingItem[] clothes){
      if (clothes.length == 0) return 0.0;
      double max = Double.MIN_VALUE;

      for (ClothingItem item : clothes){
         if (item != null && item.getPrice() > max) {
            max = item.getPrice();
         }
      }

      return max;
   }
}
