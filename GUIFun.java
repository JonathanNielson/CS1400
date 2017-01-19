import javax.swing.JFrame;
import java.awt.*;

public class GUIFun extends JFrame
{

   public GUIFun()
   {
      setTitle("Mullet Simulator");
      setSize(960,960);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
   }
   
   public void paint(Graphics g)
   {
      g.setColor(Color.RED);
      g.fillRect(480, 480, 200, 100);
   }

   public static void main (String[] args)
   {
      GUIFun g = new GUIFun();
      
      g.paint(null);
      
      
      
   }//End of Main

}//End of Class