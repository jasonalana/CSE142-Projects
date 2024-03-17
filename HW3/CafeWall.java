// Jason Alana
// 4/21/20
// CSE142
// TA: Sara Sun
// Assignment #3B
//
// This program will output a drawing of grids that can be altered by the given parameters.

import java.awt.*;

public class CafeWall {

   public static final int MORTAR = 2;

   public static void main(String[] args)  {
      DrawingPanel panel = new DrawingPanel(650, 400);
      panel.setBackground(Color.GRAY);
      Graphics g = panel.getGraphics();
      
      drawRow(0,0,4,20,g);
      drawRow(50,70,5,30,g);
      
      drawGrid(10,150,4,25,0,g);
      drawGrid(250,200,3,25,10,g);
      drawGrid(425,180,5,20,10,g);
      drawGrid(400,20,2,35,35,g);
   }
  
   public static void drawRow(int x, int y, int pairs, int size, Graphics g)  {
   //This method outputs a row of boxes based on the given parameters.
      for (int box = 0; box < pairs; box++)  {
         g.setColor(Color.BLACK);
         g.fillRect(x + 2 * box * size, y, size, size);
         g.setColor(Color.WHITE);
         g.fillRect(x + 2 * box * size + size, y, size, size);
         g.setColor(Color.BLUE);
         g.drawLine(x + 2 * box * size, y, x + 2 * box * size + size, y + size);
         g.drawLine(x + 2 * box * size, y + size, x +2 * box * size + size, y);
      }
   }
   
   public static void drawGrid(int x, int y, int pairs, int size, int offset, Graphics g) {
   //This method outputs a grid of rows based with/without and offset based on the given parameters.
      for (int i = 0; i < pairs; i++)  {
         drawRow (x, y + i * (size + MORTAR) * 2, pairs, size, g);
         drawRow (x + offset, y + size + MORTAR + i * (size + MORTAR)* 2, pairs, size, g);         
      }
   }
}