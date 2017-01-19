/*BankAccountDriver.java
*
*Created by Jonathan Nielson and Faith Satterthwaite
*
*This program allows the user to create and manage a bank account by depositing and withdrawing at will.*/

import java.util.*;

public class BankAccountDriver
{

   public static void main (String[] args)
   {
      Scanner in = new Scanner (System.in);
      Random r = new Random ();
      
      String preferredName = "";
      int assignedAccount = 0;
      int actionSelect = 0;
      int amount = 0;
      
      System.out.println("Welcome to Really Great Banking! Please enter your name to get started: ");
      preferredName = in.nextLine();
      
      assignedAccount = r.nextInt(99999);
      
      System.out.println("Welcome, " + preferredName + ". Your new account is #" + assignedAccount + ".");
      
      BankAccount b = new BankAccount (preferredName, assignedAccount);
      
      do
      {
      
         System.out.println("Press 1 to make a deposit.");
         System.out.println("Press 2 make a withdrawal.");
         System.out.println("Press 3 to get account information.");
         System.out.println("Press 4 to quit.");
         
         actionSelect = in.nextInt();
         
         if (actionSelect == 1)
         {
            System.out.println("Please enter the amount you would like to deposit: ");
            amount = in.nextInt();
            
            b.deposit(amount);
            System.out.println("Your new balance is: " + b.getBalance);
         }
      
      } while (actionSelect != 4);
   
   } //End of Main Method

} //End of Class