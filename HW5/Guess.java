// Jason Alana
// 5/5/20
// CSE142
// TA: Sara Sun
// Assignment #5
//
// This program  allows the user to play a simple 
// guessing game in which your program thinks up an integer and
// allows the user to make guesses until the user gets it right.

import java.util.*;

public class Guess   {
   public static final int MAX = 100;

   public static void main(String[] Args) {
      
      //Declaring Variables
      Scanner console = new Scanner(System.in);
      Random r = new Random();
      int totalGuess = 0;
      int bestGuess = 9999;
      int guess;  
      int totalGames = 0;  
      String repeat = "y";
      
      //Starts an intro prompt that explains the program
      introPrompt();
      
      //A while loop that keeps the program running as long as
      //the user inputs any word that starts with "Y"
      while (repeat.charAt(0) == 'y' || repeat.charAt(0) == 'Y')   {
      guess = game(console,r);
      totalGuess += guess;
      totalGames++;
      
      if (guess < bestGuess)  {
      bestGuess = guess;
      }
      
      System.out.print("Do you want to play again? ");
      repeat = console.next();
      System.out.println();
      }
      
      results(totalGames, totalGuess, bestGuess);
   }
   
   //Starts an intro prompt that explains the program
   public static void introPrompt()   {
		System.out.println("This program allows you to play a guessing game.");
		System.out.println("I will think of a number between 1 and");
		System.out.println("100 and will allow you to guess until");
		System.out.println("you get it.  For each guess, I will tell you");
		System.out.println("whether the right answer is higher or lower");
		System.out.println("than your guess.");
      System.out.println();   
   }
   
   //Runs a method that uses parameters Scanner console to take in user input and
   //Random r that generates a random number to run the guessing game until user
   //inputs correct number.  Returns the number of guesses.
   public static int game(Scanner console, Random r)   {
         System.out.println("I'm thinking of a number between 1 and " + MAX + "...");
         
         boolean gameRun = true;
         int numofGuess = 0;
         int guess;
         int randomNumber = r.nextInt(MAX) + 1;
         
         randomNumber = 42;
         
         while (gameRun == true)    {
            System.out.print("Your guess? ");
            guess = console.nextInt();
            numofGuess += 1;
            
            if (guess == randomNumber) {
               System.out.print("You got it right in " + numofGuess);
               if (numofGuess == 1)   {
                  System.out.println(" guess");
               }  else  {
                  System.out.println(" guesses");
               }          
               gameRun = false;
            }  else if  (guess > randomNumber)  {
               System.out.println("It's lower.");
            }  else  {
               System.out.println("It's higher.");
            }
         }
      return numofGuess;
   }
   
   //Method that takes in parameters int totalGames, int totalGuess, int bestGame
   //to calculate average guesses per game and output information.
   public static void results(int totalGames,int totalGuess, int bestGame)  {
      double average = (double)totalGuess/totalGames;
      average = Math.round(average * 10.0) / 10.0;
      System.out.println("Overall results:");
      System.out.println("    total games   = " + totalGames);
      System.out.println("    total guesses = " + totalGuess);
      System.out.println("    guesses/game  = " + average);
      System.out.println("    best game     = " + bestGame);
   }
}