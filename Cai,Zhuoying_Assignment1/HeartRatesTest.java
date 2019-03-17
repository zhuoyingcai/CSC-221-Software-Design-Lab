import javax.swing.JOptionPane;

public class HeartRatesTest
{
    public static void main(String[] args)
    {
        String message = "Welcome to Target Heart Rate Calculator!";
        JOptionPane.showMessageDialog(null, message);

        String Action = "C"; // default action to execute the program

        while ("C".equals(Action))
        {
            HeartRates Person = new HeartRates();

            String FirstName = JOptionPane.showInputDialog("Please enter your first name: ");
            Person.setFirstName(FirstName);
            String LastName = JOptionPane.showInputDialog("Please enter your last name: ");
            Person.setLastName(LastName);

            boolean Valid;

            do
            {
                try
                {
                    Valid = true;
                    String Month = JOptionPane.showInputDialog("Please enter the month of your birthday (MM): ");
                    Person.setMonth(Month);
                } catch (Exception e) // if input is invalid
                {
                    System.out.println("ERROR: Invalid month. Please enter again");
                    String Message = "ERROR: Invalid month. Please enter again";
                    JOptionPane.showMessageDialog(null, Message);
                    Valid = false;
                }
            } while (!Valid); // continue entering until input is valid.

            do
            {
                try
                {
                    Valid = true;
                    String Day = JOptionPane.showInputDialog("Please enter the day of your birthday (DD): ");
                    Person.setDay(Day);
                } catch (Exception e) // if input is invalid
                {
                    System.out.println("ERROR: Invalid day. Please enter again");
                    String Message = "ERROR: Invalid day. Please enter again";
                    JOptionPane.showMessageDialog(null, Message);
                    Valid = false;
                }
            } while (!Valid); // continue entering until input is valid.

            do
            {
                try
                {
                    Valid = true;
                    String Year = JOptionPane.showInputDialog("Please enter the year of your birthday (YYYY): ");
                    Person.setYear(Year);
                } catch (Exception e) // if input is invalid
                {
                    System.out.println("ERROR: Invalid year. Please enter again");
                    String Message = "ERROR: Invalid year. Please enter again";
                    JOptionPane.showMessageDialog(null, Message);
                    Valid = false;
                }
            } while (!Valid); // continue entering until input is valid.

            // show user's entered information on the panel
            String Message1 = String.format("PERSONAL INFORMATION%nName: %s %s%nDate of Birth: %s/%s/%s",
                    FirstName, LastName, Person.getMonth(), Person.getDay(), Person.getYear());
            JOptionPane.showMessageDialog(null, Message1);


            int age = Person.Age(); // calculation of user's age
            int maximum = Person.MaxHeartRate(); // calculation of user's maximum heart rate
            double[] target = Person.TargetHeartRate(); // calculation of user's target heart rate
            String message2 = String.format("Age: %d%nMaximum Heart Rate: %d%nTarget Heart Rate: %.0f - %.0f",
                    age, maximum, target[0], target[1]); // user's target heart rate is round up to whole number
            JOptionPane.showMessageDialog(null, message2);

            System.out.printf("PERSONAL INFORMATION%nName: %s %s%nDate of Birth: %s/%s/%s%nAge: %d%nMaximum Heart Rate: %d%nTarget Heart Rate: %.0f - %.0f%n%n",
                    Person.getFirstName(), Person.getLastName(), Person.getMonth(), Person.getDay(), Person.getYear(), age, maximum, target[0], target[1]);

            Action = JOptionPane.showInputDialog("Enter 'E' to exit program \nEnter 'C' to calculate again\n(Note: letter is case-sensitive)"); // user option to end or continue program
        }

        String message3 = String.format("Thank you!%nGood-Bye!");
        System.out.println("Thank you! Good-Bye!");
        JOptionPane.showMessageDialog(null, message3);
    }
}

