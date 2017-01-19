/*RouletteDriver.java
*
*Created by Jonathan Nielson on 29 Nov 2016.
*
*The driver for the Roulette.class*/

import java.util.Scanner;
import java.util.Random;

public class RouletteDriver
{

   public static void main (String[] args)
   {
      //Initialize variables and objects.
      Scanner in = new Scanner(System.in);
      Random r = new Random();
      int number = r.nextInt(37);
      Roulette q = new Roulette();
      
      //Introduce player to the rules.
      System.out.println("Today we are going to play some basic Roulette.");
      System.out.println("A random number between 0 and 36 will be chosen.");
      System.out.println("You simply decide whether that number is in the higher range (greater than 18), or in the lower range (18 or lower).");
      System.out.println();
      System.out.println("Ready? Let's go!");
      
      System.out.println("Is the number in the lower half? (Enter: 1) Or the upper half? (Enter: 2)");      
      
      //Begin the round by calling the betOnce method in the Roulette object.
      q.betOnce(in, number);
   
   } //End of Main Method
   

} //End of RouletteDriver Class