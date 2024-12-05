package inventory.controller;

import java.util.Scanner;
import java.util.ArrayList;

import java.io.File;
import java.io.FileNotFoundException;

import inventory.model.*;

public class IOController {
   /**
    * Read all the ClothingItems from a given CSV dataset
    * @param path File path to CSV dataset
    * @return A list of ClothingItem
    */
   public static ArrayList<ClothingItem> readClothingItemsFromFile(String path){
      ArrayList<ClothingItem> clothes = new ArrayList<ClothingItem>();

      try (Scanner fileScanner = new Scanner(new File(path))){
         String clothingLine = fileScanner.nextLine();

         while (fileScanner.hasNextLine()){
            clothingLine = fileScanner.nextLine();
            String[] lineContents = clothingLine.split(",");

            clothes.add(new ClothingItem(
               lineContents[0],
               lineContents[1],
               lineContents[2],
               Double.parseDouble(lineContents[3]),
               Boolean.parseBoolean(lineContents[4]),
               Boolean.parseBoolean(lineContents[5])
            ));
         }
      } catch (FileNotFoundException error){
         System.out.println("Error reading clothing items");
         System.err.println(error.getMessage());
      }

      return clothes;
   }

   /**
    * Read all the HosptialFood items from a given CSV dataset
    * @param path File path to CSV dataset
    * @return A list of HospitalFood
    */
    public static ArrayList<HospitalFood> readHospitalFoodFromFile(String path){
      ArrayList<HospitalFood> hospitalFood = new ArrayList<HospitalFood>();

      try (Scanner fileScanner = new Scanner(new File(path))){
         String foodLine = fileScanner.nextLine();

         while (fileScanner.hasNextLine()){
            foodLine = fileScanner.nextLine();
            String[] lineContents = foodLine.split(",");

            hospitalFood.add(new HospitalFood(
               lineContents[0],
               lineContents[1],
               Integer.parseInt(lineContents[2]),
               Boolean.parseBoolean(lineContents[3]),
               Double.parseDouble(lineContents[4])
            ));
         }
      } catch (FileNotFoundException error){
         System.out.println("Error reading hospital food items");
         System.err.println(error.getMessage());
      }

      return hospitalFood;
   }

   /**
    * Read all the HospitalPatients from a given CSV dataset
    * @param path File path to CSV dataset
    * @return A list of ClothingItem
    */
    public static ArrayList<HospitalPatient> readHospitalPatientsFromFile(String path){
      ArrayList<HospitalPatient> patients = new ArrayList<HospitalPatient>();

      try (Scanner fileScanner = new Scanner(new File(path))){
         String patientLine = fileScanner.nextLine();

         while (fileScanner.hasNextLine()){
            patientLine = fileScanner.nextLine();
            String[] lineContents = patientLine.split(",");

            HospitalPatient currentPatient = new HospitalPatient();

            currentPatient.setName(lineContents[0]);
            currentPatient.setEyeColor(lineContents[1]);
            currentPatient.setIsMale(Boolean.parseBoolean(lineContents[2]));
            currentPatient.setAge(Integer.parseInt(lineContents[3]));
            currentPatient.setRoomNumber(Integer.parseInt(lineContents[4]));
            currentPatient.setPriceOfStay(Double.parseDouble(lineContents[5]));

            patients.add(currentPatient);
         }
      } catch (FileNotFoundException error){
         System.out.println("Error reading hospital patients");
         System.err.println(error.getMessage());
      }

      return patients;
   }
}
