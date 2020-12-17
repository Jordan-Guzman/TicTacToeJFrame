public class Controller
{
   Model model;
   boolean buttonPress;
   
   public Controller()
   {
      model = new Model();
      buttonPress = false;
   }
   
   public void pressTimerButton()
   {
      buttonPress = true;
   }
   
   public boolean getTimerButtonPress()
   {
      return buttonPress;
   }
}