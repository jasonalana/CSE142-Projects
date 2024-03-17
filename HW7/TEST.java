/*
Our input is lines
String name = input.nextLine();
String line = input.nextLine().toLowerCase();
String counter = 0;
Split into 10 7-char arrays
*/
import java.util.*;
public class TEST {
   public static void main(String[] Args) { 
     
      //Runs program 10 times to create 10 groups of 7
      for (int x = 1; x <= 10; x++)  {
         int y = 0;
         //splits into groups of 7
         for (int i = (x * 7) - 7; i < 7 * x ; i++)   {
            char check = line.charAt(i);
            if (check == 'a')   {
               if (y == 1) {
                  countsOfA[0] += 1;
               }  else if (y == 2 || y == 3) {
                  countsOfA[1] += 1;
               }  else if (y == 4 || y == 5) {
                  countsOfA[2] += 1;
               }  else  {
                  countsOfA[3] += 1;
               } 
            y++;
            //System.out.println("x = " + x + " i = " + i + " y = " + y);    
            }
         }
      }
   }
}