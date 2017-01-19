import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Yahtzee 
{

   public static void main(String[] args)
   {
   
      //Initialize all needed variables.
      int[] dice = new int[5];
      Random r = new Random();
      Scanner in = new Scanner (System.in);
      String reroll = "";
      String godMode = "";
      
      System.out.println("Let's play some Yahtzee! Here's your first set of dice: ");
      
      //Generate the first 5 dice.
      for (int i = 0; i < 5; i++)
      {
         dice[i] = r.nextInt(6) + 1;
      }
      
      for (int i = 0; i < 5; i++)
      {
         System.out.print(dice[i] + " ");
      }
      System.out.println();
      
      //Optional First Re-roll
      for (int i = 0; i < 5; i++)
      {
         System.out.println("Would you like to Re-roll die #" + (i+1) + "? (Y/N)");
         reroll = in.nextLine();
         
         if (reroll.equalsIgnoreCase("y"))
         {
            dice[i] = r.nextInt(6) + 1;
         }
         
      }
      
      for (int i = 0; i < 5; i++)
      {
         System.out.print(dice[i] + " ");
      }
      System.out.println();
      
      //Optional Second Re-roll
      for (int i = 0; i < 5; i++)
      {
         System.out.println("Would you like to Re-roll die #" + (i+1) + "? (Y/N)");
         reroll = in.nextLine();
         
         if (reroll.equalsIgnoreCase("y"))
         {
            dice[i] = r.nextInt(6) + 1;
         }
         
      }
      
      for (int i = 0; i < 5; i++)
      {
         System.out.print(dice[i] + " ");
      }
      System.out.println();
      
      //Allow the player to manually manipulate the dice in GOD MODE. BWAHAHA!
      System.out.println("Would you like to enter God-mode and override any dice? (Y/N)");
      godMode = in.nextLine();
      
      if (godMode.equalsIgnoreCase("y"))
      {
         for (int i = 0; i < 5; i++)
         {
            System.out.println("Please enter the new value for die #" + (i+1) + ":");
            dice[i] = in.nextInt();
         }
      }
      
      System.out.println("Your final dice show: ");
      for (int i = 0; i < 5; i++)
      {
         System.out.print(dice[i] + " ");
      }
      System.out.println();
      
      //Create the arraylist to count the values of the dice.
      ArrayList<Integer> counts = new ArrayList<Integer>();
      for (int i = 0; i < 6; i++)
      {
         counts.add(0);
      }
      
      for (int i = 0; i < 5; i++)
      {
         int diceIndex = dice[i] -1;
         counts.set(diceIndex, (counts.get(diceIndex) +1));
      }
      
      //All the win/lose states possible based on the values of each dice.
      if (counts.contains(5))
      {
         System.out.println("Yahtzee!");
      }
      else if (counts.contains(4))
      {
         System.out.println("You got a Four-of-a-Kind!");
      }
      else if (counts.contains(3) && counts.contains(2))
      {
         System.out.println("That's a Full House!");
      }
      else if (counts.contains(3) && !counts.contains(2))
      {
         System.out.println("You got Three-of-a-Kind!");
      }
      else if (!counts.contains(2) && (counts.get(1) != 0) && (counts.get(2) != 0) && (counts.get(3) != 0) && (counts.get(4) != 0))
      {
         System.out.println("Large Straight! Nice Job!");
      }
      else if (!counts.contains(2) && !counts.contains(3) && !counts.contains(4) && !counts.contains(5))
      {
         System.out.println("That's a Small Straight!");
      }
      else
      {
         System.out.println("Looks like you didn't get a winning combo this time. Thanks for playing anyway!");
      }
      
      System.out.println("Thanks for playing Yahtzee!");
      
      
      //System.out.println();
      //for (int i = 0; i < 6; i++)
      //{
         //System.out.println("The number of " + (i+1) + "s is: " + counts.get(i));
      //}
   
   }

}