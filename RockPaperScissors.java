import java.util.*;
import javax.swing.*;

public class RockPaperScissors
{

   public String getUserChoice();
   {
      String playerChoice = "";
      boolean errorDetected = false;
      
      do
      {
         errorDetected = false;
         
         try
         {
            playerChoice = JOptionPane.showInputDialog(null, "Rock, Paper, or Scissors?");
         }
         catch(InputMismatchException e)
         {
            JOptionPane.showMessageDialog(null, "Something went wrong with your entry, please try again.");
            errorDetected = true;
         }
         
      } while (errorDetected == true); 
      
      return playerChoice;  
   }
   
   public String getCPUChoice();
   {
      Random r = new Random();
      int compRandomChoice = r.nextInt(3)+1;
      String CPUChoice = "";
      
      if(compRandomChoice == 1)
      {
         CPUChoice = "rock";
      }  
      
      else if(compRandomChoice == 2)
      {
         CPUChoice = "paper";
      }
      
      else
      {
         CPUChoice = "scissors";
      }    
   
      return CPUChoice;
   }
   
   public String pickWinner(String userChoice, String cpuChoice);
   {
      String result = "";
      
		if	(cpuChoice.equalsIgnoreCase("rock") & userChoice.equalsIgnoreCase("rock"))
		{
			result = "tie";
		}
		else if (cpuChoice.equalsIgnoreCase("paper") & userChoice.equalsIgnoreCase("paper"))
		{
			result = "tie";
		}
		else if (cpuChoice.equalsIgnoreCase("scissors") & userChoice.equalsIgnoreCase("scissors"))
		{
			result = "tie";
		}
		else if (cpuChoice.equalsIgnoreCase("rock") &	userChoice.equalsIgnoreCase("paper"))
		{
			result = "User";
		}
		else if (cpuChoice.equalsIgnoreCase("rock") &	userChoice.equalsIgnoreCase("scissors"))
		{
			result = "Computer";
		}
		else if (cpuChoice.equalsIgnoreCase("paper") & userChoice.equalsIgnoreCase("rock"))
		{
			result = "Computer";
		}
		else if (cpuChoice.equalsIgnoreCase("paper") & userChoice.equalsIgnoreCase("scissors"))
		{
			result = "User";
		}
		else if (cpuChoice.equalsIgnoreCase("scissors") & userChoice.equalsIgnoreCase("rock"))
		{
			result = "User";
		}
		else 
		{
			result = "Computer";
		} 
      
      return result;
   
   }

}