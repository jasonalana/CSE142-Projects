// Jason Alana
// 4/21/20
// CSE142
// TA: Sara Sun
// Assignment #3A
//
// This program will output a personal portrait.

import java.awt.*;

public class Doodle  {
   public static void main(String[] args)  {
      DrawingPanel panel = new DrawingPanel(1000, 1000);
      panel.setBackground(Color.yellow);
      Graphics g = panel.getGraphics();
      
      g.setColor(Color.BLUE);
      g.fillOval(300,300,300,300);
      g.fillOval(220,500,500,500);
      g.fillOval(100,600,300,100);
      g.fillOval(560,600,300,100);
      
      g.setColor(Color.BLACK);
      g.fillOval(330,330,100,100);     
      g.fillOval(460,330,100,100);
      
      g.setColor(Color.WHITE);
      g.fillOval(360,500,200,50); 
   }  
}

