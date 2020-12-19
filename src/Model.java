
public class Model
{
   boolean[][] playedXTiles = new boolean[3][3];
   boolean[][] playedOTiles = new boolean[3][3];
   int nobodyWins;
   int count;
   
   public Model()
   {
      setInitialTileValues();
      nobodyWins = 0;
      count = 0;
   }
   
   public void setInitialTileValues()
   {
      for(int i = 0; i < 3; i++)
      {
         playedXTiles[i][0] = false;
         
         for(int j = 0; j < 3; j++)
         {
            playedXTiles[i][j] = false;
         }
      }
      
      for(int i = 0; i < 3; i++)
      {
         playedOTiles[i][0] = false;
         
         for(int j = 0; j < 3; j++) 
         {
            playedOTiles[i][j] = false;
         }
      }
   }
   
   public void setXTiles(int row, int col)
   {
      playedXTiles[row][col] = true;
      count++;
   }
   
   public void setOTiles(int row, int col)
   {
      playedOTiles[row][col] = true;
      count++;
   }
   
   public boolean rowOneXFilled()
   {
      if((playedXTiles[0][0] == true) && (playedXTiles[0][1] == true) && (playedXTiles[0][2] == true))
      {
         
         return true;
      }
      else
      {
         nobodyWins++;
         return false;
      }
   }
   
   public boolean rowTwoXFilled()
   {
      if((playedXTiles[1][0] == true) && (playedXTiles[1][1] == true) && (playedXTiles[1][2] == true))
      {
         
         return true;
      }
      else
      {
         nobodyWins++;
         return false;
      }
   }
   
   public boolean rowThreeXFilled()
   {
      if((playedXTiles[2][0] == true) && (playedXTiles[2][1] == true) && (playedXTiles[2][2] == true))
      {
         
         return true;
      }
      else
      {
         nobodyWins++;
         return false;
      }
   }
   
   public boolean colOneXFilled()
   {
      if((playedXTiles[0][0] == true) && (playedXTiles[1][0] == true) && (playedXTiles[2][0] == true))
      {
         
         return true;
      }
      else
      {
         nobodyWins++;
         return false;
      }
   }
   
   public boolean colTwoXFilled()
   {
      if((playedXTiles[0][1] == true) && (playedXTiles[1][1] == true) && (playedXTiles[2][1] == true))
      {
         
         return true;
      }
      else
      {
         nobodyWins++;
         return false;
      }
   }
   
   public boolean colThreeXFilled()
   {
      if((playedXTiles[0][2] == true) && (playedXTiles[1][2] == true) && (playedXTiles[2][2] == true))
      {
         
         return true;
      }
      else
      {
         nobodyWins++;
         return false;
      }
   }
   
   public boolean forwardDiagonalXFilled()
   {
      if((playedXTiles[2][0] == true) && (playedXTiles[1][1] == true) && (playedXTiles[0][2] == true))
      {
         
         return true;
      }
      else
      {
         nobodyWins++;
         return false;
      }
   }
   
   public boolean backwardDiagonalXFilled()
   {
      if((playedXTiles[0][0] == true) && (playedXTiles[1][1] == true) && (playedXTiles[2][2] == true))
      {
         
         return true;
      }
      else
      {
         nobodyWins++;
         return false;
      }
   }
   
   public boolean rowOneOFilled()
   {
      if((playedOTiles[0][0] == true) && (playedOTiles[0][1] == true) && (playedOTiles[0][2] == true))
      {
         
         return true;
      }
      else
      {
         nobodyWins++;
         return false;
      }
   }
   
   public boolean rowTwoOFilled()
   {
      if((playedOTiles[1][0] == true) && (playedOTiles[1][1] == true) && (playedOTiles[1][2] == true))
      {
         
         return true;
      }
      else
      {
         nobodyWins++;
         return false;
      }
   }
   
   public boolean rowThreeOFilled()
   {
      if((playedOTiles[2][0] == true) && (playedOTiles[2][1] == true) && (playedOTiles[2][2] == true))
      {
         
         return true;
      }
      else
      {
         nobodyWins++;
         return false;
      }
   }
   
   public boolean colOneOFilled()
   {
      if((playedOTiles[0][0] == true) && (playedOTiles[1][0] == true) && (playedOTiles[2][0] == true))
      {
         
         return true;
      }
      else
      {
         nobodyWins++;
         return false;
      }
   }
   
   public boolean colTwoOFilled()
   {
      if((playedOTiles[0][1] == true) && (playedOTiles[1][1] == true) && (playedOTiles[2][1] == true))
      {
         
         return true;
      }
      else
      {
         nobodyWins++;
         return false;
      }
   }
   
   public boolean colThreeOFilled()
   {
      if((playedOTiles[0][2] == true) && (playedOTiles[1][2] == true) && (playedOTiles[2][2] == true))
      {
         
         return true;
      }
      else
      {
         nobodyWins++;
         return false;
      }
   }
   
   public boolean forwardDiagonalOFilled()
   {
      if((playedOTiles[2][0] == true) && (playedOTiles[1][1] == true) && (playedOTiles[0][2] == true))
      {
         
         return true;
      }
      else
      {
         nobodyWins++;
         return false;
      }
   }
   
   public boolean backwardDiagonalOFilled()
   {
      if((playedOTiles[0][0] == true) && (playedOTiles[1][1] == true) && (playedOTiles[2][2] == true))
      {
         
         return true;
      }
      else
      {
         nobodyWins++;
         return false;
      }
   }
   
   public boolean boardFilled()
   {
      if(count == 9)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   public boolean tieGame()
   {
      if(nobodyWins == 16)
      {
         return true;
      }
      else
      {
         return false;
      }
     
   }
}
