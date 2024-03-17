// Jason Alana
// 4/21/20
// CSE142
// TA: Sara Sun
// Assignment #4
//
// This program compares two applicants to
// determine which student seems like the stronger
// applicant.

import java.util.*;

public class Admit {
   public static void main(String[] Args) {
     
      //Declares scanner
      Scanner console = new Scanner(System.in);
      
      //Outputs an introductory prompt
      prompt();
      
      //Calculates, receives, and stores GPA and Exam scores in variables
      double examScore1 = getScores(console,1);
      double gpaScore1 = getGPA(console);
      double examScore2 = getScores(console,2);
      double gpaScore2 = getGPA(console);
      
      //Calculates, compares, and outputs best student
      finalScore(examScore1,gpaScore1,examScore2,gpaScore2);
   }
   
   //Prompts a user on what the program does and needs.
   public static void prompt()   {
      System.out.println("This program compares two applicants to");
      System.out.println("determine which one seems like the stronger");
      System.out.println("applicant.  For each candidate I will need");
      System.out.println("either SAT or ACT scores plus a weighted GPA.");
      System.out.println();
   }
   
   //Gets ACT or SAT scores, and returns overall exam scores
   public static double getScores(Scanner console, int appNum)   {
      System.out.println("Information for applicant #" + appNum + ":");
      System.out.print("    do you have 1) SAT scores or 2) ACT scores? ");
      double score;
      int actSat = console.nextInt();
      if (actSat == 1)
      {
         score = getSatScores(console);
      }
      else
      {
         score = getActScores(console);
      }
      System.out.println("    exam score = " + Math.round(score * 10.0) / 10.0);
      return score;
   }
   
   //Gets, calculates, and returns overall SAT score
   public static double getSatScores(Scanner console) {
      System.out.print("    SAT math? ");
      double score = console.nextDouble() * 2;
      System.out.print("    SAT critical reading? ");
      score = score + console.nextDouble();
      System.out.print("    SAT writing? ");
      score = (score + console.nextDouble()) / 32;
      return score;
   }

   //Gets, calculates, and returns overall ACT score   
   public static double getActScores(Scanner console) {
      System.out.print("    ACT English? ");
      double score = console.nextInt();
      System.out.print("    ACT math? ");
      score = 2 * console.nextInt() + score;
      System.out.print("    ACT reading? ");
      score = console.nextInt() + score;
      System.out.print("    ACT science? ");
      score = (console.nextInt() + score) / 1.8;
      return score;
   }
   
   //Gets, calculates, and returns overall GPA score   
   public static double getGPA(Scanner console) {
      System.out.print("    overall GPA? ");
      double actualGpa = console.nextDouble();
      System.out.print("    max GPA? ");
      double maxGpa = console.nextDouble();
      System.out.print("    Transcript Multiplier? ");
      double transcriptMultiplier = console.nextDouble();  
        
      double gpaScore = (actualGpa / maxGpa) * 100 * transcriptMultiplier;
      System.out.println("    GPA score = " + Math.round(gpaScore * 10.0) / 10.0);
      System.out.println();
      return gpaScore;
   }  
   
   //Gets, calculates overall final score, outputting which applicant is better or whether they are equal.
   public static void finalScore(double examScore1, double gpaScore1, double examScore2, double gpaScore2)   {
      double student1 = gpaScore1 + examScore1;
      double student2 = gpaScore2 + examScore2;
         
      System.out.println("First applicant overall score  = " + Math.round(student1 * 10.0) / 10.0);
      System.out.println("Second applicant overall score = " + Math.round(student2 * 10.0) / 10.0);
      
      if (student1 > student2)   {
         System.out.print("The first applicant seems to be better");
      } 
      else if (student2 > student1) {
         System.out.print("The second applicant seems to be better");
      }
      else  {
         System.out.print("The two applicants seem to be equal");
      }
   }
}