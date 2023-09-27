package graphics;
import javax.swing.*;
/**
 * This class let you see an interpretation of a String array
 * as an graphics image in a window.
 */
public class Graphics{
  private JFrame frame;
  /**
   * The constructors needs an instance of Picture
   * @param pic a String array that will be interpreted as an graphics
   * image
   */
  public Graphics(Picture pic){
    frame = new JFrame("Ajedrez");
    GPicture gp = new GPicture(pic);
    frame.add(gp);
    frame.setSize(gp.getWidth() + 5, gp.getHeight() + 28);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  /**
   * Shows the imagen in a JFrame window.
   */
  public void print(){
    frame.repaint();
    frame.setVisible(true);
  }
}
