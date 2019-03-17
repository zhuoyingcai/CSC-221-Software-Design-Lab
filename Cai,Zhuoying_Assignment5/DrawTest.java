import javax.swing.*;
import java.awt.*;

public class DrawTest
{
    public static void main(String[] args)
    {
        /**
         * Get the screen size of the user
         */
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth(); // width of the screen
        int screenHeight = (int) screenSize.getHeight(); // height of the screen

        DrawFrame frame = new DrawFrame();
        // Do nothing when close the frame, windowListener is added.
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setSize(screenWidth, screenHeight); // set the frame to the size of the screen size.
        frame.setVisible(true);
        frame.setResizable(true);
    }
}