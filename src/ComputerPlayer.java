import java.util.Random;

public class ComputerPlayer
{
   Random rand;
   int row;
   int col;
   
   ComputerPlayer()
   {
      rand = new Random();
   }
   
   public int getRow()
   {
      return row;
   }
   
   public int getCol()
   {
      return col;
   }
}