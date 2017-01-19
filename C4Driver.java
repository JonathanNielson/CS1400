import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class ConnectFourGUI extends JComponent implements MouseListener
{
   public static final int WIDTH = 350;
   public static final int HEIGHT = 300;
   public static final int BOARD_WIDTH = WIDTH / 50;
   public static final int BOARD_HEIGHT = HEIGHT / 50;
   private int[][] board = new int[BOARD_HEIGHT + 2][BOARD_WIDTH + 2];
   
   public ConnectFourGUI()
   {
      //Have the object say it is listening for mouse events
      addMouseListener(this);
      
      for(int x = 0; x < BOARD_WIDTH; x++)
      {
         for(int y = 0; y < BOARD_HEIGHT; y++)
         {
            board[y][x] = 0; //set all values to dead
         }
      }
      
      //board[2][2] = 1;
      //board[3][2] = 2;
   }
   
   private int dropPiece(int col)
   {
      int row = BOARD_HEIGHT;
        //int tempRow = 0;
        boolean isEmpty = false;

        if (col < 1 || col > BOARD_WIDTH) //If it's not a valid column, tell them
        {
            //Show message box
            JOptionPane.showMessageDialog(null, "Click on a column please.");
        }
        else if (board[0][col] == 0)  //If top spot is empty
        {
            //Loop through column to find empty spot
            do {
                if (board[row][col] == 0)
                {
                    board[row][col] = 1; 
                    return row;
                }
                else
                {
                    row--;
                    isEmpty = false;
                }
            } while (!isEmpty);

            
            //validMove = true;
            }
            return -1;
        }
   
   @Override
   public void paint(Graphics graphics)
   {
      /*start at 1 to not ever check the first row and first column
      and loop to less than or equal to board dimensions*/
      for(int x = 1; x <= BOARD_WIDTH; x++)
      {
         for(int y = 1; y <= BOARD_HEIGHT; y++)
         {
            if (board[y][x] == 0) //if value is dead
            {
               graphics.setColor(Color.BLACK);
               graphics.drawRect(x * 50, y * 50, 50, 50);
            }
            else if (board[y][x] == 1) //if value is not dead
            {
               graphics.setColor(Color.BLACK);
               graphics.drawRect(x * 50, y * 50, 50, 50);
               graphics.setColor(Color.RED);
               graphics.fillOval(x * 50, y * 50, 50, 50);
               System.out.println(x + " " + y);
            }
            else if (board[y][x] == 2) //if value is not dead
            {
               graphics.setColor(Color.BLACK);
               graphics.drawRect(x * 50, y * 50, 50, 50);
               graphics.setColor(Color.GREEN);
               graphics.fillOval(x * 50, y * 50, 50, 50);
            }
         }
      }
   }
   
   @Override
    public void mouseClicked(MouseEvent e) {
        /*e.getX() and e.GetY() give you the coordinates of the board.  Divide by 10 to get the correct cell*/
        int trueX = e.getX() / 50;
        int trueY = e.getY() / 50;
        int rowNum = dropPiece(trueX);
        
        if (rowNum == -1)
        {
         //TODO: error message or message to user
        }
        else
        {
            //TODO: Depending on user, set to 1 or 2
            //board[trueX][rowNum] = 1;
            repaint();
        }
        //make cell alive when clicked
        //board[trueX][trueY] = 1;

        System.out.println("I clicked the mouse here at row " + rowNum + ", column " + trueX);
        System.out.println(board[rowNum][trueX]);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {    
    }

    @Override
    public void mouseExited(MouseEvent e) {  
    }
}

public class C4Driver
{
   public static void main (String [] args)
   {
      ConnectFourGUI c4 = new ConnectFourGUI();
      JFrame window = new JFrame();
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setBounds(60, 60, ConnectFourGUI.WIDTH + 250, ConnectFourGUI.HEIGHT + 150);
      window.getContentPane().add(c4);
      window.setVisible(true);
   }
}