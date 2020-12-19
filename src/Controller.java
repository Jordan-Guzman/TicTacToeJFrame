public class Controller
{
   Model model;
   boolean buttonPress;
   int tieTracker;
   
   public Controller()
   {
      model = new Model();
      buttonPress = false;
      tieTracker = 0;
   }
   
   public void pressTimerButton()
   {
      buttonPress = true;
   }
   
   public boolean getTimerButtonPress()
   {
      return buttonPress;
   }
   
   public void xTileTracker(int row, int col)
   {
      model.setXTiles(row, col);
   }
   
   public void oTileTracker(int row, int col)
   {
      model.setOTiles(row, col);
   }
   
   public boolean checkXPlays()
   {
      if(model.rowOneXFilled() == true)
      {
         System.out.println("X WINS TOP");
         return true;
      }
      
      else if(model.rowTwoXFilled() == true)
      {
         System.out.println("X WINS MID");
         return true;
      }
      
      else if(model.rowThreeXFilled() == true)
      {
         System.out.println("X WINS BOT");
         return true;
      }
      
      else if(model.colOneXFilled() == true)
      {
         System.out.println("X WINS COL 1");
         return true;
      }
      
      else if(model.colTwoXFilled() == true)
      {
         System.out.println("X WINS COL 2");
         return true;
      }
      
      else if(model.colThreeXFilled() == true)
      {
         System.out.println("X WINS COL 3");
         return true;
      }
      
      else if(model.forwardDiagonalXFilled() == true)
      {
         System.out.println("X WINS FORWARD DIAGONAL");
         return true;
      }
      
      else if(model.backwardDiagonalXFilled() == true)
      {
         System.out.println("X WINS BACKWARD DIAGONAL");
         return true;
      }
      
      else
      {
         tieTracker++;
         return false;
      }
   }
   
   public boolean checkOPlays()
   {
      if(model.rowOneOFilled() == true)
      {
         System.out.println("O WINS TOP");
         return true;
      }
      
      else if(model.rowTwoOFilled() == true)
      {
         System.out.println("O WINS MID");
         return true;
      }
      
      else if(model.rowThreeOFilled() == true)
      {
         System.out.println("O WINS BOT");
         return true;
      }
      
      else if(model.colOneOFilled() == true)
      {
         System.out.println("O WINS COL 1");
         return true;
      }
      
      else if(model.colTwoOFilled() == true)
      {
         System.out.println("O WINS COL 2");
         return true;
      }
      
      else if(model.colThreeOFilled() == true)
      {
         System.out.println("O WINS COL 3");
         return true;
      }
      
      else if(model.forwardDiagonalOFilled() == true)
      {
         System.out.println("O WINS FORWARD DIAGONAL");
         return true;
      }
      
      else if(model.backwardDiagonalOFilled() == true)
      {
         System.out.println("O WINS BACKWARD DIAGONAL");
         return true;
      }
      
      else
      {
         tieTracker++;
         return false;
      }
   }
   
   public void tieGame()
   {
      if(tieTracker == 9)
         System.out.println("Tie Game");
      
   }
}