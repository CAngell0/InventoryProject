package inventory.model;

public class ClothesItem {
   //clothesType, size, color, isMale, hasDesign
   private String clothesType;
   private String color;
   private int size;
   private double price;
   private boolean isMale;
   private boolean hasDesign;

   public ClothesItem(){
      this.clothesType = "";
      this.color = "";
      this.size = 0;
      this.isMale = false;
      this.hasDesign = false;
   }
   public ClothesItem(String clothesType, String color, int size, double price, boolean isMale, boolean hasDesign){
      this.clothesType = clothesType;
      this.color = color;
      this.size = size;
      this.price = price;
      this.isMale = isMale;
      this.hasDesign = hasDesign;
   }

   public String getClothesType(){
      return this.clothesType;
   }
   public String getColor(){
      return this.color;
   }
   public int getSize(){
      return this.size;
   }
   public double getPrice(){
      return this.price;
   }
   public boolean getIsMale(){
      return this.getIsMale();
   }
   public boolean getHasDesign(){
      return this.hasDesign;
   }

   @Override
   public String toString() {
      String str = "This item has the following characteristics:";
      str += "\n\t- ClothesType: " + this.clothesType;
      str += "\n\t- Color: " + this.color;
      str += "\n\t- Size: " + this.size;
      str += "\n\t- Price: " + this.price;
      str += "\n\t- IsMale: " + this.isMale;
      str += "\n\t- HasDesign: " + this.hasDesign;
      return str;
   }
}
