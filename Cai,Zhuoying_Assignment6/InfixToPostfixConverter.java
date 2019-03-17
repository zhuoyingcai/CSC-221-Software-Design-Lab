/**
 * In this exercise, we'll write a Java version of the infix-to-postfix conversion algorithm.
 *
 * @author Zhuoying Cai
 * @Since 11-28-2017
 */

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class InfixToPostfixConverter
{
    public InfixToPostfixConverter() {}

    /*
     * default the number of left parenthesis with 1 because
     * a right parenthesis will automatically append to the postfix.
     */
    private int countLeft = 1;
    private int countRight = 0;

    /**
     * This method is used to remove all the white space in the infix.
     * @param infix This is the infix expression that the user enter.
     * @return StringBuffer This returns the infix expression without white space.
     */
    private StringBuffer removeWhiteSpace(StringBuffer infix)
    {
        int j = 0;

        for (int i = 0; i < infix.length(); i++)
        {
            // if current character is not a white space
            if (!Character.isWhitespace(infix.charAt(i)))
            {
                // move the current character to next position
                infix.setCharAt(j++, infix.charAt(i));
            }
        }

        return infix.delete(j, infix.length());
    }

    public StringBuffer convertToPostfix(StringBuffer infix)
    {
        Stack<Character> stack = new Stack<>();
        StringBuffer postfix = new StringBuffer();
        stack.push('(');
        infix.append(')');

        infix = removeWhiteSpace(infix);

        for (int i = 0; i < infix.length(); i++)
        {
            if (infix.charAt(i) == '(') // if current character is a left parenthesis
            {
                if (infix.charAt(i + 1) == ')') // if next character is a right parenthesis
                    throw new UnsupportedOperationException("Invalid expression");
                else
                {
                    countLeft++; // count the number of left parenthesis
                    stack.push('('); // push it into the stack
                }
            }
            else if (Character.isLetterOrDigit(infix.charAt(i))) // if current character is a letter or a digit
            {
                if (infix.charAt(i + 1) == '(')
                    throw new UnsupportedOperationException("Invalid expression");
                else
                    postfix.append(infix.charAt(i)); // append it to the postfix
            }
            else if (infix.charAt(i) == '.') // if current character is a decimal point
            {
                // if the decimal point is a the last position of the infix or
                // the following character is not a digit or
                // the following character is a operator
                if (i == infix.length() - 2 || !Character.isDigit(infix.charAt(i + 1)) || isOperator(infix.charAt(i + 1)))
                {
                    throw new IllegalArgumentException("Invalid number");
                }
                else
                    postfix.append(infix.charAt(i));
            }
            else if (!isOperator(infix.charAt(i)) && // if current character is not an allowable operator and
                    infix.charAt(i) != '.' &&        // is not a decimal point and
                    infix.charAt(i) != '(' && infix.charAt(i) != ')') // is not parenthesis
            {
                throw new NoSuchElementException("Illegal operator");
            }
            else if (isOperator(infix.charAt(0)) || // if the first character in the infix is an operator or
                    isOperator(infix.charAt(infix.length() - 2)) || // the last character is an operator or
                    isOperator(infix.charAt(i)) && isOperator(infix.charAt(i + 1))) // there are two consecutive operators
            {
                throw new UnsupportedOperationException("Invalid expression");
            }
            else
                postfix.append(" "); // append a space to postfix as the end of the variable

            if (isOperator(infix.charAt(i)) && !stack.empty()) // if the current character is an operator
            {
                /*
                 * while at the top of the stack is an operator and
                 * if it has higher precedence then the current operator
                 */
                while (isOperator(stack.peek()) && !precedence(stack.peek(), infix.charAt(i)))
                {
                    postfix.append(stack.pop()) // append it to the postfix
                            .append(" ");
                }

                stack.push(infix.charAt(i)); // push the current character to the stack
            }
            else if (infix.charAt(i) == ')') // if the current character is a right parenthesis
            {
                countRight++; // count the number of right parenthesis

                /*
                 * while the character on the top of the stack is not a left parenthesis and
                 * the stack if not empty
                 */
                while (stack.peek() != '(' && !stack.empty())
                {
                    // append the character on the top of the stack to the postfix
                    postfix.append(stack.pop())
                            .append(" ");
                }

                // pop the left parenthesis from the stack when it is on the top of the stack
                if (stack.peek() == '(')
                    stack.pop();
            }
        }

        // if the number of left parenthesis is not equal to the number of right parenthesis
        if (countLeft != countRight)
        {
            countLeft = 1;
            countRight = 0;
            throw new EmptyStackException();
        }

        countLeft = 1;
        countRight = 0;

        return postfix;
    }

    /**
     * This method is used to check if the character is an operator.
     * @param c This is a character.
     * @return boolean This returns true if the character is an operator or
     *                  returns false if the character is not an operator.
     */
    public boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%';
    }

    /**
     * This method is used to determine if operator 1 has higher precedence than operator 2.
     * @param operator1 This is the first operator.
     * @param operator2 This is the second operator.
     * @return boolean  This returns true if operator 1 has lower precedence than operator 2 or
     *                  returns false if operator 1 has higher or equal precedence than operator 2.
     */
    public boolean precedence(char operator1, char operator2)
    {
        // default precedence value
        int opValue1 = 1;
        int opValue2 = 1;

        if (operator1 == '+' || operator1 == '-')
            opValue1 = 1;
        if (operator1 == '*' || operator1 == '/' || operator1 == '%')
            opValue1 = 2;
        if (operator1 == '^')
            opValue1 = 3;
        if (operator2 == '+' || operator2 == '-')
            opValue2 = 1;
        if (operator2 == '*' || operator2 == '/' || operator2 == '%')
            opValue2 = 2;
        if (operator2 == '^')
            opValue2 = 3;

        return opValue1 < opValue2;
    }
}
