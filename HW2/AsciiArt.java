// Jason Alana
// 4/15/20
// CSE142
// TA: Sara Sun
// Assignment #2A
//
// This program will output a drawing of MT. EVEREST

public class AsciiArt {
   public static void main(String [] args){
      mountainTop();
      mountainBase();
   }
   
   public static void mountainTop()   {
      for (int line = 1; line <= 3; line++)  {
         for (int star = 1; star <= (-1 * line + 9); star++) {
            System.out.print("*");
         } 
         System.out.print("/");
         for (int dot = 1; dot <= (2 * line - 1); dot++) {
            System.out.print(".");
         }
         System.out.print("\\");
         for (int star = 1; star <= (-1 * line + 9); star++) {
            System.out.print("*");
         }
         System.out.println();
      }
   }
   public static void mountainBase()  {
      for (int line = 1; line <= 5; line++)  {
         for (int star = 1; star <= (-1 * line + 6); star++)   {
            System.out.print("*");
         }
         System.out.print("/");
         for (int zero = 1; zero <= (2 * line + 5); zero++)  {
            System.out.print("0");
         }
         System.out.print("\\");
         for (int star = 1; star <= (-1 * line + 6); star++)   {
            System.out.print("*");
         }         
         System.out.println();
      }
   }
}


