/*Roulette.java
*
*Created by Jonathan Nielson on 29 Nov 2016.
*
*This class functions with the RouletteDriver class to create a rudimentary version of Roulette.*/

import java.util.Scanner;

public class Roulette
{
   //Method that determines the win conditions of the game and prints out results.
   public static void betOnce (Scanner in , int number)
   {
      //Initialize needed variables.
      int playerSelection = 0;
      int randomNumber = 0;
      playerSelection = in.nextInt();
      randomNumber = number;
      
      System.out.println("The number was " + randomNumber);
      
      //Win-logic 
      if (playerSelection == 1 && randomNumber > 18)
      {
         System.out.println("Sorry, you lost this round.");
      }
      else if (playerSelection == 1 && randomNumber <= 18 && randomNumber != 0)
      {
         System.out.println("Good guess! You won this round.");
      }
      else if (playerSelection == 2 && randomNumber > 18)
      {
         System.out.println("You win! Nice job.");
      }
      else if (playerSelection == 2 && randomNumber <= 18 && randomNumber != 0)
      {
         System.out.println("Bummer. You lose the round.");
      }
      else if (randomNumber == 0)
      {
         System.out.println("House wins on zeros. You lose this round.");
      }
      else
      {
         System.out.println("Error in win-logic.");
      }
      
      //Returns nothing.
      return ;
   
   } //End of betOnce Method

} //End of Roulette Class