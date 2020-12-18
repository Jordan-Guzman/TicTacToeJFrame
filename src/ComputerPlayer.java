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
   
   public void randomSelect()
   {
      row = rand.nextInt(3);
      col = rand.nextInt(3);
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