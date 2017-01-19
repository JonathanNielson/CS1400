import java.util.Scanner;

public class PigLatinTranslator
{
   //Start main method.
   public static void main (String[] args)
   {
   
      Scanner in = new Scanner (System.in);
      
      //Initialize needed variables.
      int firstVowel = 0;
      int endOfWord = 0; 
      String englishWord = "";
      String firstChunk = "";
      String secondChunk = "";
      
      System.out.println("Welcome to the Pig Latin Translator!");
      
      //Overall loop: Get user input, translate, exit program when prompted.
      do
      {
         System.out.println("Please enter one word you would like translated into Pig Latin (be sure not to include any spaces), or press Q to quit:");
         englishWord = in.nextLine();
         englishWord = englishWord.toLowerCase();
         
         //Call the vowelFinder function to find the first vowel and the end of the word.
         firstVowel = vowelFinder(englishWord);
         endOfWord = englishWord.length();
         
         //Check to see if the word starts with a vowel and apply those rules.
         if (firstVowel == 0)
         {
            System.out.println("The translation is: " + englishWord + "way");
         }
         //Apply rules for all words starting with consonants.
         else
         {
            firstChunk = englishWord.substring(0,firstVowel);
            secondChunk = englishWord.substring(firstVowel,endOfWord);
            System.out.println("The translation is: " + secondChunk + firstChunk + "ay");
         }
         
      } while (!englishWord.equalsIgnoreCase("Q"));
   
   }
   
   //Method for determining the first vowel in a given word.
   public static int vowelFinder (String englishWord)
   {
      int result = 0;
      int positionA = 0;
      int positionE = 0;
      int positionI = 0;
      int positionO = 0;
      int positionU = 0;
      
      //Find the index for every vowel in a given word. If the vowel doesn't exist, set it's index
      //to an arbitrarily large number so it doesn't interfere with the Math.min function.
      positionA = englishWord.indexOf("a");
      if (positionA < 0)
      {
         positionA = 990;
      }
      positionE = englishWord.indexOf("e");
      if (positionE < 0)
      {
         positionE = 980;
      }
      positionI = englishWord.indexOf("i");
      if (positionI < 0)
      {
         positionI = 970;
      }
      positionO = englishWord.indexOf("o");
      if (positionO < 0)
      {
         positionO = 960;
      }
      positionU = englishWord.indexOf("u");
      if (positionU < 0)
      { 
         positionU = 950;
      }
      
      //Find which vowel occurs first in the given word.
      result = Math.min(positionA, Math.min(positionE, Math.min(positionI, Math.min(positionO, positionU))));
      
      return result;
   }

}