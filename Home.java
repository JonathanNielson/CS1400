import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame
{
   private JFrame homeScreen;
   private JLabel lblName;
   private JTextField txtName;
   private JButton btnOK;
   
   private MyButtonListener listen1 = new MyButtonListener();
   
   //Constructor
   public Home ()
   {
      homeScreen = new JFrame();
      
      homeScreen.setSize(960,960);
      homeScreen.setTitle("Mullet Simulator");
      homeScreen.setDefaultCloseOperation(homeScreen.EXIT_ON_CLOSE);
      homeScreen.setLayout(new FlowLayout());
      
      lblName = new JLabel("Enter your name:");
      txtName = new JTextField(20);
      btnOK = new JButton("OK");
      
      btnOK.addActionListener(listen1);
      txtName.addActionListener(listen1);
      
      homeScreen.add(lblName);
      homeScreen.add(txtName);
      homeScreen.add(btnOK);
      
      homeScreen.setVisible(true);
      
   }//End of Constructor
   
   public static void main (String[] args)
   {
   
      Home h = new Home();
      h.repaint();
   
   } //End of Main
   
   public void paint(Graphics g)
   {
      g.drawRect(10,10,10,10);
   }

   private class MyButtonListener implements ActionListener
   {
   
      public void actionPerformed (ActionEvent e)
      {
         txtName.setBackground(Color.BLUE);
         
         homeScreen.setVisible(true);
      }
   
   }

}//End of Home Class