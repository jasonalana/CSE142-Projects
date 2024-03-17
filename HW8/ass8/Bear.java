// Bear gets assigned white or black
// based on boolean polar, alternates
// between "/" and "\", infects others
// in front, hops if front is empty, 
// turns left otherwise.

import java.awt.*;

public class Bear extends Critter   {
   private boolean polarity;
   private int count;
   
   public Bear(boolean polar) {
      this.polarity = polar;
   }
   
   public Action getMove(CritterInfo info) {
      if (info.getFront() == Neighbor.OTHER)  {
         return Action.INFECT;
      }  else if (info.getFront() == Neighbor.EMPTY)  {
         return Action.HOP;
      }  else  {
         return Action.LEFT;
      }
   }

   public Color getColor() {
      if (this.polarity)  {
         return Color.WHITE;
      }  else  {
         return Color.BLACK;
      }
   }

   public String toString() {
      count = count + 1;
      if (count % 2 == 1)  {
         return "/";
      }  else  {
        return "\\";
      }
   }    
}