import javax.swing.JOptionPane;

public class PaneFun
{

   public static void main (String[] args)
   {
      int greaseLevels = 0;
      int confirmation = 0;
   
      //Display a message box
      JOptionPane.showMessageDialog(null, "Whaddup, bitches?");
      
      //Show input box
      greaseLevels = Integer.parseInt(JOptionPane.showInputDialog(null, "On a scale of 1 to 10, how greasy is your mullet?"));
   
      JOptionPane.showMessageDialog(null, greaseLevels + " out of 10, huh? That's pretty greasy.");
      
      //Generate a confirm box
      confirmation = JOptionPane.showConfirmDialog(null, "Are you sure your mullet is that greasy?\n You may want to get that checked out.");
      
      if (confirmation == JOptionPane.YES_OPTION)
      {
         JOptionPane.showMessageDialog(null, "Well, I'm glad to hear you're confident at least!");
      }
   }

}