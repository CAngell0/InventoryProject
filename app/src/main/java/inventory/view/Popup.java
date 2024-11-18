package inventory.view;

import javax.swing.JOptionPane;

public class Popup {
   public Popup(){}

   public void displayMessage(String message){
      JOptionPane.showMessageDialog(null, message);
   }

   public String askQuestion(String question){
      String answer = JOptionPane.showInputDialog(question);
      return (answer == null) ? "" : answer;
   }
}
