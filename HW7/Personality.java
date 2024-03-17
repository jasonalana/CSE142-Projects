// Jason Alana
// 5/26/20
// CSE142
// TA: Sara Sun
// Assignment #7
//
// This program determines personality type based on
// an input file, then outputs the results on to another file

import java.util.*;
import java.io.*;

public class Personality   {
   
   public static final int DIMENSIONS = 4;
   
   public static void main(String[] Args) throws FileNotFoundException {
   
   Scanner console = new Scanner(System.in);
   
   String inputFile = "";  
   String outputFile;
   
   int countsOfA[] = new int[DIMENSIONS];
   int countsOfB[] = new int[DIMENSIONS];
   int percentage[] = new int[DIMENSIONS];
   int arrayOfLine[] = new int[70];
   
      // Intro
      intro();
      
      // Takes in Input file name
      System.out.print("input file name? ");
      inputFile = fileName(console);
      Scanner input = new Scanner(new File (inputFile));
      
      // Takes in Output file name
      System.out.print("output file name? ");
      outputFile = fileName(console);
      PrintStream output = new PrintStream(new File(outputFile));
      
      // Processes file
      input(output,input,countsOfA,countsOfB,percentage);
             
   }
   
   // Outputs an Intro to the program  
   public static void intro() {
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter. It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();
   }
   
   // Prompts user for input file name using Scanner console
   // returns input file name
   public static String fileName(Scanner console)  {
      String fileName = console.next();
      return fileName;
   }
   
   // Takes in input file, returns string consisting
   // of input
   public static void input(PrintStream output, Scanner input, 
   int[] countsOfA, int[] countsOfB, int[] percentage)  {
   
      String personality = "";
      char filter = 'a';   
      // Reads input line by line
      while (input.hasNextLine())   {
         String name = input.nextLine();
         String line = input.nextLine().toLowerCase();
         
         // Take in Line, count how many A answers
         filter = 'a';
         count(line, countsOfA, filter);
         
         // Take in line, count how many B answers
         filter = 'b';
         count(line, countsOfB, filter);
         
         // Takes in countsOfA and countsOfB to calculate
         // percentage
         percentage(countsOfA,countsOfB,percentage);  
         
         // Determines personality type
         personality = personalityType (percentage, personality);
         // System.out.println(personality);
         
         // Prints data
         print(output,name,percentage,personality);
         
         personality = "";
         
         clearArray(countsOfA);         
         clearArray(countsOfB);
             
      }   
      
   }
   
   // Turns line into an array, takes in String line, and
   // int[] arrayOfLine.
   public static void count(String line, int[] count, char filter)   {
      //Runs program 10 times to create 10 groups of 7
      for (int x = 1; x <= 10; x++)  {
         int y = 1;
         //splits into groups of 7
         for (int i = (x * 7) - 7; i < 7 * x ; i++)   {
            char check = line.charAt(i);
            if (check == filter)   {
               if (y == 1) {
                  count[0] += 1;
               }  else if (y == 2 || y == 3) {
                  count[1] += 1;
               }  else if (y == 4 || y == 5) {
                  count[2] += 1;
               }  else  {
                  count[3] += 1;
               }     
            }
            y++;
         }
      }
   }

   // Clears an array, takes in int[] countsOfA or int[] countsOfB
   public static void clearArray (int [] count)   {
      for (int i = 0; i < DIMENSIONS; i++)  {
         count[i] = 0;
      }
   }
   
   // Turns array into a percentage, takes in int[] countsOfA
   // and int[] countsOfB 
   public static void percentage (int[] countsOfA, int[] countsOfB, 
   int [] percentage)  {
   
      for (int i = 0; i < DIMENSIONS; i++)   {
         double countB = countsOfB[i];
         double countA = countsOfA[i];
         double divide = (countB/ (countA + countB)) * 100.0;
         
         int percent = (int) Math.round(divide);
         
         percentage[i] = percent;
      }
   }
   
   // Determines personality type based on percentages, takes in
   // int[] percentage, stores results in int[] personality
   public static String personalityType (int[] percentage, String personality) {
   
      String[] personalityA = {"E", "S", "T", "J"};
      String[] personalityB = {"I", "N", "F", "P"};
      
      for(int i = 0; i < DIMENSIONS; i++) {
         if (percentage[i] > 50) {
            personality = personality + personalityB[i];
         }  else if ( percentage[i] == 50)   {
            personality = personality + "X";
         }  else  {
            personality = personality + personalityA[i];
         } 
      }
      return personality;
   }
   
   // Prints out data to output.txt using PrintStream output
   // String name, int[] percentage, String personality 
   public static void print(PrintStream output, String name, int[] percentage, String personality) {
      output.print(name + ": ");
      output.print(Arrays.toString(percentage));
      output.println(" = " + personality);
   }
}