// Jason Alana
// 4/15/20
// CSE142
// TA: Sara Sun
// Assignment #2B
//
// This program will output a drawing of a rocket, which size can be changed through int SIZE.

public class DrawRocket  {
   public static final int SIZE = 3;
   public static void main(String[] args) {
      cone();
      line();
      middleTop();
      middleBottom();
      line();
      middleBottom();
      middleTop();
      line();
      cone();
   }
   public static void cone() {
      for (int line = 1; line <= (2 * SIZE -1) ; line++)   {
         for (int space = 1; space <= (-1 * line + 2 * SIZE); space++)  {
            System.out.print(" ");
         }
         for (int fslash = 1; fslash <= line; fslash++)  {
            System.out.print("/");
         }
         System.out.print("**");
         for (int bslash = 1; bslash <= line; bslash++)  {
            System.out.print("\\");
         }
         System.out.println();
      }
   }
   
   public static void line() {
      System.out.print("+");
      for (int i = 1;i <= 2 * SIZE; i++){
         System.out.print("=*");
         }
      System.out.print("+");
      System.out.println();
   }
   
   public static void middleTop()  {
      for (int line = 1; line <= SIZE; line++)  {
         System.out.print("|");      
         for (int dot = 1; dot <= (-1 * line + 1 * SIZE); dot++)   {
            System.out.print(".");
         }
         for (int arrow = 1; arrow <= line; arrow++)  {
            System.out.print("/\\");
         }
         for (int dot = 1; dot <= (-2 * line + 2 * SIZE); dot++)   {
            System.out.print(".");
         }
         for (int arrow = 1; arrow <= line; arrow++)  {
            System.out.print("/\\");
         }
         for (int dot = 1; dot <= (-1 * line + 1 * SIZE); dot++)   {
            System.out.print(".");
         }
         System.out.print("|");         
         System.out.println();
      }  
   }
   public static void middleBottom()  {
      for (int line = 1; line <= SIZE; line++)  {
         System.out.print("|");
         for (int dot = 1; dot <= (1* line - 1); dot++){
         System.out.print(".");
         }
         for (int arrow = 1; arrow <= (-1 * line + SIZE + 1); arrow++)   {
         System.out.print("\\/");
         }
         for (int dot = 1; dot <= (2 * line - 2); dot++) {
         System.out.print(".");
         }
         for (int arrow = 1; arrow <= (-1 * line + SIZE + 1); arrow++)   {
         System.out.print("\\/");
         }
         for (int dot = 1; dot <= (1* line - 1); dot++){
         System.out.print(".");
         }
         System.out.print("|");
      System.out.println();
      } 
   }
}
   