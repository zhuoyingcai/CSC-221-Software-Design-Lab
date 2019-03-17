import javax.swing.*;

public class LargeTypeDisplay_Test
{
    public static void main(String[] args)
    {
        LargeTypeDisplay display = new LargeTypeDisplay();

        display.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        display.setSize(550,315);
        display.setVisible(true);
        display.setResizable(false);
    }
}
