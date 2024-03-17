// Jason Alana
// 5/19/20
// CSE142
// TA: Sara Sun
// Assignment #6
//
// This program displays a graph of baby names and
// its ranks, based on user input of name and gender.

import java.util.*;
import java.io.*;
import java.awt.*;

public class Names   {

   public static final int NUMOFDECADES = 10;
   public static final int STARTYEAR = 1920;
   public static final int HORIZONTALWIDTH = 90;
   
   public static void main(String[] Args) throws FileNotFoundException  {
      Scanner input = new Scanner(new File ("names2.txt"));
      Scanner console = new Scanner(System.in);
      String name;
      String sex;
      String line;

      
      // Outputs Intro
      intro();
      
      // Takes in User Input, Returns Name and Sex;
      name = name(console);
      sex = sex(console);
      
      // Finds line containing name and sex; returns it
      line = find(input, name, sex);
      if (!line.equals(""))  {
         plotGraph(line);
      }  else  {
         System.out.println("name/sex combination not found");
      }
   }
   
   // Outputs intro
   public static void intro() {
      System.out.println("This program allows you to search through the");
      System.out.println("data from the Social Security Administration");
      System.out.println("to see how popular a particular name has been");
      System.out.println("since " + STARTYEAR + ".");
      System.out.println();
   }
   
   // Takes in User Input for name
   public static String name(Scanner console)  {
      System.out.print("name? ");
      String name = console.next();
      return name;
   }
   
   // Takes in User Input for sex
   public static String sex(Scanner console) {
      System.out.print("sex (M or F)? ");
      String sex = console.next();
      return sex;
   }
   
   // Finds line with search term, and returns the whole line
   // (if there is one); returns an empty string if not found
   // ignores case in looking for the names
   // Takes in Scanner input, String name, and String sex
   public static String find(Scanner input, String name, String sex) {
      String line;
      
      while (input.hasNextLine())   {
         line = input.nextLine();
         
         if (line.toLowerCase().contains(name.toLowerCase())) {
            if (sex(line,name,sex) == true)  {
               return line;
            }
         }
      }
      return line = "";
   }
   
   // Finds the gender token in the line
   // concatenates name and sex to find double gender names
   public static boolean sex(String line, String name, String sex)   {
      Scanner data = new Scanner(line);
      String nameSex = name + " " + sex;
      
      String fileName = data.next();
      String fileSex = data.next();
      String fileNameSex = fileName + " " + fileSex;
      
      if (fileNameSex.toLowerCase().equals(nameSex.toLowerCase()))   {
         return true;
      }  else  {
         return false;
      }
   }
   
   // Creates a graph of data, taking in String line
   public static void plotGraph(String line)   {
      int width = HORIZONTALWIDTH * NUMOFDECADES;
      DrawingPanel panel = new DrawingPanel(width, 550);
      Graphics g = panel.getGraphics();
      g.drawLine(0,25,width,25);
      g.drawLine(0,525,width,525);
      for (int x = 0; x < NUMOFDECADES; x++) {
         g.drawLine(HORIZONTALWIDTH * x, 0, HORIZONTALWIDTH * x, 550);
         g.drawString(("" + (STARTYEAR + 10 * x)), 0 + HORIZONTALWIDTH * x, 550);      
      }
      plotData(line,g);
   }
   
   // Plots the data on the graph, taking in String line,
   // Graphics g; from plotGraph
   public static void plotData(String line, Graphics g)  {
      g.setColor(Color.RED);
      Scanner data = new Scanner(line);
      
      int x = 0;
      int rank = 0;
      int y = 0;
      int yOld = 0;
      double temp;
      String description;
      
      description = data.next();
      description = description + " " + data.next();
      
      for (int i = 0; i < NUMOFDECADES; i++)  {
         rank = data.nextInt();
         yOld = y;
         if (rank > 0)  {
            temp = 24 + Math.round((rank/2.0));
            y = (int) temp;
         }  else  {
            y = 525;
         }
         
         g.drawString(description + " " + String.valueOf(rank), x, y);
         g.drawLine(x - HORIZONTALWIDTH, yOld, x, y);
         x += HORIZONTALWIDTH;       
      }  
   }
}