import javax.swing.*;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class InfixToPostfixConverterTest
{
    public static void main(String[] arg)
    {
        InfixToPostfixConverter converter = new InfixToPostfixConverter();
        boolean valid = true;
        String action = "C";

        while ("C".equalsIgnoreCase(action)) // default action
        {
            do
            {
                try
                {
                    valid = true;
                    StringBuffer infix = new StringBuffer(JOptionPane.showInputDialog(
                            "Please enter an infix expression\n" +
                            "Acceptable operators include +, -, *, /, ^, and %", // acceptable operator
                            "(x + 123) * 0.24 + var1")); // example of infix
                    System.out.println("The infix expression you entered is: " + infix);
                    StringBuffer postfix = converter.convertToPostfix(infix);
                    System.out.println("The postfix expression is: " + postfix.toString() + "\n");

                    String postfixExpression = "The postfix expression is: " + postfix.toString();
                    JOptionPane.showMessageDialog(null, postfixExpression);
                }
                catch (UnsupportedOperationException e)
                {
                    System.out.println("Illegal expression. Please enter again.\n");
                    JOptionPane.showMessageDialog(null, "Illegal expression. Please enter again.");
                    valid = false;
                }
                catch (EmptyStackException e)
                {
                    System.out.println("Mismatched parenthesis. Please enter again.\n");
                    JOptionPane.showMessageDialog(null, "Mismatched parenthesis. Please enter again..");
                    valid = false;
                }
                catch (NoSuchElementException e)
                {
                    System.out.println("Illegal operator. Please enter again.\n");
                    JOptionPane.showMessageDialog(null, "Illegal operator. Please enter again.");
                    valid = false;
                }
                catch (IllegalArgumentException e)
                {
                    System.out.println("Illegal number. Please enter again.\n");
                    JOptionPane.showMessageDialog(null, "Illegal number. Please enter again");
                    valid = false;
                }
                catch (NullPointerException e) // when the user cancel the program
                {
                    System.out.println("You canceled the program.");
                    JOptionPane.showMessageDialog(null, "You canceled the program.");
                    System.exit(1);
                }
            } while (!valid);

            action = JOptionPane.showInputDialog("Enter 'E' to exit program\n" + "Enter 'C' to convert another infix expression");
        }
    }
}
