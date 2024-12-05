package inventory.controller;

import java.util.Scanner;
import java.util.ArrayList;

import java.io.File;
import java.io.FileNotFoundException;

import inventory.model.ClothingItem;

public class IOController {
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
}
