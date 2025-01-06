package inventory.controller.typeManipulation;

import inventory.model.HospitalPatient;

public class HospitalPatientHelpers {

   /**
    * Count the amount of patients in a certain age range
    * @param minAge The minimum age to search by
    * @param maxAge The maximum age to search by
    * @param patients The array of patients to search in
    * @return A count of patients that are within the designated age range
    */
   public int countPatientsInAgeRange(int minAge, int maxAge, HospitalPatient[] patients){
      if (patients.length == 0) return 0;
      int count = 0;
      
      for (HospitalPatient patient : patients){
         if (patient != null && patient.getAge() >= minAge && patient.getAge() <= maxAge) count++;
      }

      return count;
   }

   /**
    * Gets the average price of all prices of stay from a specified HospitalPatient array
    * @param patients The array to calculate an average from
    * @return An average price
    */
   public double getAveragePriceOfStay(HospitalPatient[] patients){
      if (patients.length == 0) return 0.0;
      double average = 0.0;

      for (HospitalPatient item : patients) {
         if (item != null) average += item.getPriceOfStay();
      }
      average = average / patients.length;

      return average;
   }

   /**
    * Gets the smallest price of stay of the items in a given HospitalPatient array
    * @param patients The array to get the minimum price of stay from
    * @return The minimum price
    */
   public double getMinPriceOfStay(HospitalPatient[] patients){
      if (patients.length == 0) return 0.0;
      double min = Double.MAX_VALUE;

      for (HospitalPatient item : patients){
         if (item != null && item.getPriceOfStay() < min) min = item.getPriceOfStay();
      }

      return min;
   }
   
   /**
    * Gets the largest price of stay of the items in a given HospitalPatient array
    * @param patients The array to get the maximum price from
    * @return The maximum price
    */
   public double getMaxPriceOfStay(HospitalPatient[] patients){
      if (patients.length == 0) return 0.0;
      double max = Double.MIN_VALUE;

      for (HospitalPatient item : patients){
         if (item != null && item.getPriceOfStay() > max) {
            max = item.getPriceOfStay();
         }
      }

      return max;
   }
}
