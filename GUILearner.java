import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class GUILearner extends JFrame //implements ActionListener
{
   //JTextField txtName;
   //JFrame homeScreen;
   public static int playColumn = 5;
   public static int playRow = 2;

   //Constructor
   public GUILearner()
   {
      setTitle("Connect-Four!");
      setSize(960,960);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
   }
     
  /*public class MyButtonListener implements ActionListener
  {
   
      public void actionPerformed (ActionEvent e)
      {
         txtName.setBackground(Color.BLUE);
         
         homeScreen.setVisible(true);
      }
   
   }//End of ActionListener Class*/

   public static void main (String[] args)
   {
      GUILearner g = new GUILearner();
      
      for (int i = 0; i < 4; i++)
      {
         g.repaint();
      }
      
      
   }//End of Main
   
   public void paint(Graphics G)
   {
      
      for (int i = 0; i < 7; i++)
      {
         G.drawRect(((i*125)+50), 150, 125, 750);
      }
      
      for (int h = 0; h < 7; h++)
      {
         for (int j = 0; j < 6; j++)
         {
            G.drawOval(((h*125)+80),((j*125)+180), 70,70);
         }
      }
      
      G.setColor(Color.RED);
      G.fillOval(((GUILearner.playColumn*125)+80),((GUILearner.playRow*125)+180),70,70);
      
      G.fillOval(((3*125)+80),((2*125)+180),70,70);
   }//End of GameField Painter

}//End of Class