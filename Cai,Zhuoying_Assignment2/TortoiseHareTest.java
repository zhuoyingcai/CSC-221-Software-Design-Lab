import javax.swing.*;

public class TortoiseHareTest
{
    public static void main(String[] args)
    {
        String message = "Tortoise Hare Simulation";
        JOptionPane.showMessageDialog(null, message);

        String Action = "C"; // default action to execute the program

        TortoiseHare simulation = new TortoiseHare();

        while ("C".equals(Action))
        {
            System.out.printf("BANG !!!!!%nAND THEY'RE OFF !!!!!%n%n");

            // the simulation continues when no one reach the end
            while (simulation.getPositionT() != simulation.getEndPosition() - 1
                    && simulation.getPositionH() != simulation.getEndPosition() - 1)
            {
                simulation.rollDice();
                System.out.printf("Random number: %d%n", simulation.getRandNumb());
                System.out.printf("Position of Tortoise: %d%n", simulation.getPositionT() + 1);
                System.out.printf("Position of Hare: %d%n", simulation.getPositionH() + 1);

                simulation.printTrack();

                // when contenders land on the same position
                if (simulation.getPositionT() != 0 && simulation.getPositionH() != 0
                        && simulation.getPositionT() != simulation.getEndPosition() - 1
                        && simulation.getPositionH() != simulation.getEndPosition() - 1
                        && simulation.getPositionT() == simulation.getPositionH())
                {
                    System.out.printf("OUCH!!!%n%n");
                }

                // adjust position once per second
                try
                {
                    Thread.sleep(1000);
                }
                catch (Exception e) {}

            }

            if (simulation.getPositionT() == simulation.getEndPosition() - 1
                    && simulation.getPositionH() == simulation.getEndPosition() - 1)
            {
                System.out.printf("It's a tie.%n%n");
            } else if (simulation.getPositionT() == simulation.getEndPosition() - 1)
            {
                System.out.printf("TORTOISE WINS!!! YAY!!!%n%n");
            } else if (simulation.getPositionH() == simulation.getEndPosition() - 1)
            {
                System.out.printf("Hare wins. Yuch.%n%n");
            }

            Action = JOptionPane.showInputDialog("If you wish to simulate again with a different endpoint\n" +
                                                "Press 'C' to continue or press 'E' to exist the program.");


            boolean valid;

            if (Action.equals("C"))
            {
                do
                {
                    try
                    {
                        valid = true;
                        String End = JOptionPane.showInputDialog("Please enter a number: \n" +
                        "(Enter 70 if you wish to start the simulation again with the same endpoint)");
                        simulation = new TortoiseHare(Integer.parseInt(End));
                    }
                    catch (Exception e) // if user input is invalid
                    {
                        System.out.println("ERROR: Invalid number. Please enter again.");
                        String Message = "ERROR: Invalid number. Please enter again.";
                        JOptionPane.showMessageDialog(null, Message);
                        valid = false;
                    }
                } while (!valid); // continue entering until input is valid.

                System.out.println(simulation.getEndPosition());
            }
        }
    }
}

