import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
   JButton computerSelect;
   ActionListener tileSelect = new PlayerButtonPress();
   ActionListener computerPress = new ComputerButtonPress();
   
   String xPath = "TicTacToe/X.png";
   String oPath = "TicTacToe/O.png";
   Icon x;
   Icon o;
   JLabel result;
   
   
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
            board[row][col] = new JPanel();
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
   
   
   private class PlayerButtonPress implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         JButton xLabel = (JButton)e.getSource();
         JPanel panel = (JPanel) xLabel.getParent();
         System.out.println("X BUTTON");
         
         panel.removeAll();
         panel.revalidate();
         panel.add(result = new JLabel(o),BorderLayout.CENTER);
         panel.repaint();
      }
   }
   
   private class ComputerButtonPress implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         JButton oLabel = (JButton)e.getSource();
         JPanel panel = (JPanel) oLabel.getParent();
         System.out.println("O Button");
         panel.removeAll();
         
//         panel.removeAll();
//         panel.revalidate();
//         panel.add(playerSelect = new JButton(), BorderLayout.CENTER);
//         playerSelect.setLayout(new BorderLayout());
//         playerSelect.add(new JLabel(o), BorderLayout.CENTER);
//         playerSelect.setBackground(Color.BLUE);
//         playerSelect.addActionListener(computerPress);
//         panel.repaint();
      }
   }
   
   public void compPress()
   {
//      computerSelect = buttons[2][1];
//      computerSelect.addActionListener(computerPress);
      buttons[1][2].doClick();
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