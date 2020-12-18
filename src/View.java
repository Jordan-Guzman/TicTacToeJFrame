import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class View extends JFrame implements ActionListener
{
   private static final long serialVersionUID = 1L;
   JFrame frame;
   GameTimer timer;
   
   int count = 0;
   
   JPanel[][] board = new JPanel[3][3];
   JButton[][] buttons = new JButton[3][3];
   JButton timerButton;
   HumanPlayer human;
   Controller controller;
   JPanel timerBar;
   JLabel timerText = new JLabel("00:00:00");
   String str = "00:00:00";
   JButton button;
   JButton playerPush;
   JButton computerPush;
   ActionListener tileSelect = new ButtonPress();
   Random rand = new Random();
   int row;
   int col;
   
   String xPath = "TicTacToe/X.png";
   String oPath = "TicTacToe/O.png";
   Icon x;
   Icon o;
   JLabel result;
   boolean oLabel = false;
   boolean xLabel = false;
   int updatedRow;
   int updatedCol;
   
   
   public View()
   {
      timer = new GameTimer();
      frame = new JFrame();
      controller = new Controller();
      human = new HumanPlayer();
      x = new ImageIcon(xPath);
      o = new ImageIcon(oPath);
      frame.setSize(850, 850);
      frame.setTitle("Checkers");
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
      frame.setVisible(true);
      frame.setLayout(new GridLayout(4, 3, 2, 2));
      createBoard();
      active();
   }
   
   public void createBoard()
   {
      int row;
      int col;
      
      for(row = 0; row < 3; row++)
      {
         JPanel square = new JPanel();
         square.setLayout(new BorderLayout());
         square.setBackground(Color.BLUE);
         frame.add(square);
         square.add(button = new JButton(), BorderLayout.CENTER);
         button.setBackground(Color.BLUE);
         button.addActionListener(tileSelect);
         buttons[row][0] = button;
         
         for(col = 1; col < 3; col++)
         {
            JPanel square2 = new JPanel();
            square2.setLayout(new BorderLayout());
            square2.setBackground(Color.BLUE);
            frame.add(square2);
            square2.add(button = new JButton(), BorderLayout.CENTER);
            button.setBackground(Color.BLUE);
            button.addActionListener(tileSelect);
            buttons[row][col] = button;
         }
      }
      for(int n = 0; n < 2; n++)
      {
         timerBar();
         if(n == 1)
         {
            //add JLabel that updates text of timer
            timerBar.add(timerText);
            timerBar.setBackground(Color.LIGHT_GRAY);
         }
      }
      frame.add(timerButton());
      compPress();
   }
   
   private class ButtonPress implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         JButton button = (JButton)e.getSource();
         JPanel panel = (JPanel) button.getParent();
         
         if(getOLabel() == true)
         {
            System.out.println("O BUTTON");
            panel.removeAll();
            panel.revalidate();
            panel.add(result = new JLabel(o),BorderLayout.CENTER);
            result.setBackground(Color.BLUE);
            panel.repaint();
            resetOLabel();
            buttons[row][col] = null;
         }
         else 
         {
            
            for(int m = 0; m < 3; m++)
            {
               for(int n = 0; n < 3; n++)
               {
                  if(buttons[m][n] == (JButton)e.getSource())
                  {
                     System.out.println("row " + m + " " + "column " + n);
                     panel.removeAll();
                     panel.revalidate();
                     panel.add(result = new JLabel(x),BorderLayout.CENTER);
                     result.setBackground(Color.BLUE);
                     panel.repaint();
                     buttons[m][n] = null;
                  }
               }
            }
            compPress();
         }
      }
   }
   
   private void resetOLabel()
   {
      oLabel = false;
   }
   
   private void setOLabel()
   {
      oLabel = true;
   }
   
   public boolean getOLabel()
   {
      return oLabel;
   }
   
   public void compPress()
   {
      row = rand.nextInt(3);
      col = rand.nextInt(3);
//      updatedRow = row;
//      updatedCol = col;
      if(buttons[row][col] != null)
      {
         setOLabel();
         buttons[row][col].doClick();
      }
      else
      {
         compPress();
      }
   }
   
   private void timerBar()
   {
      timerBar = new JPanel();
      timerBar.setBackground(Color.LIGHT_GRAY);
      frame.add(timerBar);
   }
   
   public JButton timerButton()
   {
      timerButton = new JButton("Start");
      timerButton.addActionListener(this);
      return timerButton;
   }
   
   public void actionPerformed(ActionEvent e)
   {
      if(count < 1)
      {
         timerButton.setText("Stop");
         count++;
      }
      else
      {
         timerButton.setText("Start");
         resetButtonCount();
      }
      controller.pressTimerButton();
      timerButtonPressed();
   }
   
   public void timerButtonPressed()
   {
      if(controller.getTimerButtonPress() == true)
      {
         timer.startRun();
      }
      else
      {
         System.out.println("Error. Timer not working.");
      }
   }
   
   private void resetButtonCount()
   {
      count = 0;
   }
   
   public void active()
   {
      while(frame.isDisplayable())
      {
         timerText.setText(timer.getTimerValue());
      }
   }
}