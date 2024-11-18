package inventory.controller;

import inventory.view.Popup;

public class Controller {
   private Popup view;

   public Controller(){
      this.view = new Popup();
   }

   public void start(){
      System.out.println("Hello World!");
   }
}
