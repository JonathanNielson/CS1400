import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConnectFourGUI extends JFrame
{  

   public static JButton currentPlayer = new JButton("This sure is a good lookin label");
   public static JButton column1 = new JButton(" V ");
   public static JButton column2 = new JButton(" V ");
   public static JButton column3 = new JButton(" V ");
   public static JButton column4 = new JButton(" V ");
   public static JButton column5 = new JButton(" V ");
   public static JButton column6 = new JButton(" V ");
   public static JButton column7 = new JButton(" V ");
   
   
   /*Set up a character array slightly larger than the playfield we actually want.
   The extra row will be a kind of barrier to ensure that the program doesn't try
   to place a piece out of bounds. It also acts as a visual aid when displaying the game board.*/
     
   public static String[][] gameField = new String[7][7];
   public static Random rand = new Random();
   public static Scanner in = new Scanner (System.in);
   public static int playColumn = 7;
   public static int playRow = 7;
   public static int compColumn = 7;
   public static int compRow = 7;
   public static boolean inputError = false;
   public static int boardHeight = 950;
   public static int boardWidth = 800;
   public static int columnWidth = 100;
   public static int columnHeight = 600;
   public static String player1Name = "";
   public static String player2Name = "";  
   
   ColumnButtonListener listen1 = new ColumnButtonListener();
   
   //Constructor
   public ConnectFourGUI()
   {
      setTitle("Connect-Four!");
      setSize(boardWidth,boardHeight);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(null);
      column1.setBounds(50,245,100,20);      
      column2.setBounds(150,245,100,20);
      column3.setBounds(250,245,100,20);
      column4.setBounds(350,245,100,20);
      column5.setBounds(450,245,100,20);
      column6.setBounds(550,245,100,20);
      column7.setBounds(650,245,100,20);
      column1.addActionListener(new ColumnButtonListener());
      add(column1);
      add(column2);
      add(column3);
      add(column4);
      add(column5);
      add(column6);
      add(column7);
      currentPlayer.setBounds(300,100,200,30);
      add(currentPlayer);
      //currentPlayer.setVisible(true);
      
      setVisible(true);
      
   } //End of Constructor

   public class ColumnButtonListener implements ActionListener
   {
   
      public void actionPerformed (ActionEvent e)
      {
         //player1Name.setBackground(Color.BLUE);
         
         //graphField.setVisible(true);
      }
   
   } //End of ActionListener Class
   
   public void paint(Graphics G)
   {
      //Draw the rectangles of the gameboard.
      for (int i = 0; i < 7; i++)
      {
         G.drawRect(((i*columnWidth)+50), 300, columnWidth, columnHeight);
      }
      
      //Draw the empty circles of the gameboard.
      for (int h = 0; h < 7; h++)
      {
         for (int j = 0; j < 6; j++)
         {
            G.drawOval(((h*columnWidth)+60),((j*100)+310), 80, 80);
         }
      }
      
      G.setColor(Color.RED);
      G.fillOval(((ConnectFourGUI.playColumn*columnWidth)+60),((ConnectFourGUI.playRow*columnWidth)+310),80,80);
      
      G.setColor(Color.BLACK);
      G.fillOval(((ConnectFourGUI.compColumn*columnWidth)+60),((ConnectFourGUI.compRow*columnWidth)+310),80,80);
      
      //G.fillOval(((3*125)+80),((2*125)+180),70,70);
      
   } //End of Paint Method (Object?)
   
    
   public static void main (String[] args)
   {
      ConnectFourGUI c = new ConnectFourGUI();
      c.repaint();
      
      player1Name = JOptionPane.showInputDialog(null, "Welcome to Connect-Four! Please enter the name of the first player:");
      
      player2Name = JOptionPane.showInputDialog(null, "Player 2, please enter your name:");
      
      currentPlayer.setText("Select a Column, " + player1Name);
      //c.repaint();
      
      //This nested loop initializes the string array entirely with a neutral character that's visually representative of a kind of gameboard.
      for (int a = 0; a < 7; a++)
      {
         for(int b = 0; b < 7; b++)
         {
            gameField[a][b] = "| ";
         }
      }
     
      //Character 'b' is used to signify the bottom. This loop places b's all along that extra bottom row.
      for (int j = 0; j < 7; j++)
      {
          gameField[6][j] = "__";
      }
     
     
      System.out.println("You'll be playing against the computer today. But don't worry, it's really quite bad at this game!");
     
      //Set the stage for the game and address the user by name.
      System.out.println("There are 7 columns you can drop a game piece into.");
      System.out.println("You're pieces will show up as a \"p\" on the game board and the computer's as a \"c\"."); 
     
      do
      {
         //This try catch handles exceptions of mismatched types as well as going out of bounds.
         try
         {
            //This loop places the game pieces for the user and the computer. It's the soul of this program.
            do
            {
               
               c.repaint();
               currentPlayer.setText("Select a Column, " + player1Name);
               System.out.println("Which column do you want to play?");
               playColumn = (in.nextInt() - 1);
               int i = 0;
        
               /*This loop searches the column the player has selected from top to bottom. Once it finds a placed game piece, or the 
               bottom of the board, it assigns the proper coordinates just above the found piece for where the player's piece will be
               placed*/
               do
               { 
         
                  if ((gameField[i][playColumn].equals("p ")) || (gameField[i][playColumn].equals("c ")) || (gameField[i][playColumn].equals("__")))
                  {
                     playRow = (i-1);
                  }
         
                  i = (i + 1);
               } while ((!gameField[(i-1)][playColumn].equals("p ")) && (!gameField[(i-1)][playColumn].equals("c ")) && (!gameField[i-1][playColumn].equals("__")));
        
               //With the given coordinates from the prior loop, the player's piece is finally placed in the appropriate spot.
               gameField[playRow][playColumn] = "p ";
               
               currentPlayer.setText("Select a Column, " + player2Name);
               c.repaint();
        
               //Reset the counter and computer selects it's play column via a random number.
               System.out.println("Player 2, which column do you want to play?");
               compColumn = (in.nextInt() - 1);
               i = 0;
        
               //This loop takes the computer's selected column and finds the appropriate row for placement.
               do
               {
                  if ((gameField[i][compColumn].equals("p ")) || (gameField[i][compColumn].equals("c ")) || (gameField[i][compColumn].equals("__")))
                  {
                     compRow = (i-1);
                  }
         
                  i = (i + 1);
               } while ((!gameField[(i-1)][compColumn].equals("p ")) && (!gameField[(i-1)][compColumn].equals("c ")) && (!gameField[i-1][compColumn].equals("__")));
        
               //With the given coordinate from the prior loop, the computer's piece is placed in the appropriate spot.
               gameField[compRow][compColumn] = "c ";
        
               //Print out the gameboard after every turn
               for (int k = 0; k < 7; k++)
               {
                  for (int l = 0; l < 7; l++)
                  {
                     System.out.print(gameField[k][l]);
                  }
                  System.out.println();
               }
               
               c.repaint();
        
               //Reset the try/catch detection
               inputError = false;
     
            } while ((checkRows(gameField) != "Player Wins") && (checkRows(gameField) != "Computer Wins") && (checkColumns(gameField) != "Player Wins") && (checkColumns(gameField) != "Computer Wins") && (checkDiagonals(gameField) != "Player Wins") && (checkDiagonals(gameField) != "Computer Wins"));
         }
     
         catch (InputMismatchException|ArrayIndexOutOfBoundsException e)
         {
            System.out.println("Sorry, it looks like you typed in something incorrectly");
            System.out.println("Please enter a column number between 1 and 7. Also, be sure to use digits only!");
            in.nextLine();
            inputError = true;
         }
      } while (inputError == true);
     
      //After the sub-methods check for a 4-in-a-row in any direction, this block of if statements determines a winner and prints out an appropriate response.
      if (checkRows(gameField).equals("Player Wins"))
      {
         System.out.println("Nice job! You connected 4 horizontally. You won!");
      }
     
      else if (checkColumns(gameField).equals("Player Wins"))
      {
         System.out.println("Right on! You got connected 4 in a column! You won!");
      }
     
      else if (checkDiagonals(gameField).equals("Player Wins"))
      {
         System.out.println("That's a diagonal streak! You win!");
      }
     
      else if (checkRows(gameField).equals("Computer Wins"))
      {
         System.out.println("That's game! Looks like the computer won this time.");
      }
     
      else if (checkColumns(gameField).equals("Computer Wins"))
      {
         System.out.println("The computer connect 4 in that column. You lose this round.");
      }
     
      else if (checkDiagonals(gameField).equals("Computer Wins"))
      {
         System.out.println("The computer wins with the diagonal streak! Bummer!");
      }
   
   }
   
   //Method for detecting a horizontal streak by either the user or the computer in any row.
   public static String checkRows (String[][] gameField)
   {
      String result = "";
      int hitCount = 0;
      
      for (int h = 0; h < 6; h++)
      {
         for (int e = 0; e < 7; e++)
         {
            if (gameField[h][e].equals("p "))
            {
               hitCount = (hitCount + 1);
            }
            if (gameField[h][e].equals("c "))
            {
               hitCount = 0;
            }
            if (gameField[h][e].equals("| "))
            {
               hitCount = 0;
            }
            if (hitCount >= 4)
            {
               result = "Player Wins";
            }
         }
      }
      
      for (int h = 0; h < 6; h++)
      {
         for (int e = 0; e < 7; e++)
         {
            if (gameField[h][e].equals("c "))
            {
               hitCount = (hitCount + 1);
            }
            if (gameField[h][e].equals("p "))
            {
               hitCount = 0;
            }
            if (gameField[h][e].equals("| "))
            {
               hitCount = 0;
            }
            if (hitCount >= 4)
            {
               result = "Computer Wins";
            }
         }
      }
      
      return result;
   } 
   
   //Method that checks every column for a 4-in-a-row for both the player and computer.
   public static String checkColumns (String[][] gameField)
   {
      String result = "";
      int hitCount = 0;
      
      for (int h = 0; h < 7; h++)
      {
         for (int e = 0; e < 6; e++)
         {
            if (gameField[e][h].equals("p "))
            {
               hitCount = (hitCount + 1);
            }
            if (gameField[e][h].equals("c "))
            {
               hitCount = 0;
            }
            if (gameField[e][h].equals("| "))
            {
               hitCount = 0;
            }
            if (hitCount >= 4)
            {
               result = "Player Wins";
            }
         }
      }
      
      for (int h = 0; h < 7; h++)
      {
         for (int e = 0; e < 6; e++)
         {
            if (gameField[e][h].equals("c "))
            {
               hitCount = (hitCount + 1);
            }
            if (gameField[e][h].equals("p "))
            {
               hitCount = 0;
            }
            if (gameField[e][h].equals("| "))
            {
               hitCount = 0;
            }
            if (hitCount >= 4)
            {
               result = "Computer Wins";
            }
         }
      }
      
      return result;
   } 
   
   
   //Using nested if statements inside of nested for loops, this method finds connections diagonally for both the player and computer.
   public static String checkDiagonals (String[][] gameField)
   {
      String result = "";
      
      for (int i = 0; i < 3; i++)
      {
         for (int k = 0; k < 4; k++)
         {
            if (gameField[i][k].equals("p "))
            {
               if (gameField[(i+1)][(k+1)].equals("p "))
               {
                  if (gameField[(i+2)][(k+2)].equals("p "))
                  {
                     if (gameField[(i+3)][(k+3)].equals("p "))
                     {
                        result = "Player Wins";
                     }
                  }
               }
            }
         }
      }
      
      for (int i = 0; i < 3; i++)
      {
         for (int k = 6; k >= 3; k--)
         {
            if (gameField[i][k].equals("p "))
            {
               if (gameField[(i+1)][(k-1)].equals("p "))
               {
                  if (gameField[(i+2)][(k-2)].equals("p "))
                  {
                     if (gameField[(i+3)][(k-3)].equals("p "))
                     {
                        result = "Player Wins";
                     }
                  }
               }
            }
         }
      }
      
      for (int i = 0; i < 3; i++)
      {
         for (int k = 0; k < 4; k++)
         {
            if (gameField[i][k].equals("c "))
            {
               if (gameField[(i+1)][(k+1)].equals("c "))
               {
                  if (gameField[(i+2)][(k+2)].equals("c "))
                  {
                     if (gameField[(i+3)][(k+3)].equals("c "))
                     {
                        result = "Computer Wins";
                     }
                  }
               }
            }
         }
      }
      
      for (int i = 0; i < 3; i++)
      {
         for (int k = 6; k >= 3; k--)
         {
            if (gameField[i][k].equals("c "))
            {
               if (gameField[(i+1)][(k-1)].equals("c "))
               {
                  if (gameField[(i+2)][(k-2)].equals("c "))
                  {
                     if (gameField[(i+3)][(k-3)].equals("c "))
                     {
                        result = "Computer Wins";
                     }
                  }
               }
            }
         }
      }
      
      
      return result;
   } 

}