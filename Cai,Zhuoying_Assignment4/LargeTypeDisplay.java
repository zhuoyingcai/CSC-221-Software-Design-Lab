/**
 * <h1>Large-Type Displays for People with Low Vision</h1>
 * The accessibility of computers and the Internet to all people, regardless of disabilities,
 * is becoming more important as these tools play increasing roles in our personal and business
 * lives. According to a recent estimate by the World Health Organization (http://www.who.int/en/),
 * 124 million people worldwide have low vision. People with low vision might prefer to choose a
 * font and/or a larger font size when reading electronic documents and web pages.
 *
 * @author Zhuoying Cai
 * @since 11-12-2017
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class LargeTypeDisplay extends JFrame
{
    /* JButtons */
    private final JButton decreaseFont; // button to decrease font size
    private final JButton increaseFont; // button to increase font size
    private final JButton changeBackgroundColor; // button to change background color
    private final JButton changeFontColor; // button to change font color
    /* JComboBox */
    private final JComboBox<String> selectFont; // allow user to select font styles
    private static final String[] fonts = {"Serif", "SansSerif", "Monospaced"};
    /* JCheckBox */
    private final JCheckBox boldCheckBox; // allow user to select bold text
    /* JTextArea */
    private final JTextArea textArea; // allow user to type text
    /* JPanel */
    private final JPanel background; // adds all JComponents to JPanel

    /* Default values */
    private Color backgroundColor = Color.LIGHT_GRAY; // default background color
    private Color fontColor = Color.BLACK; // default font color
    private int fontSize = 18; // default type text font size
    private int fontEmphasis = Font.PLAIN; // default type text font style

    /**
     * This constructor adds all JComponents to JFrame
     */
    public LargeTypeDisplay()
    {
        super("Large-Type Displays for People with Low Vision");

        background = new JPanel();
        background.setBackground(backgroundColor);
        background.setLayout(new FlowLayout());

        /* set decrease font button with Arial font, no emphasis and size 20 */
        decreaseFont = new JButton("Decrease Font Size");
        decreaseFont.setFont(new Font("Arial", Font.PLAIN, 20));
        background.add(decreaseFont);
        /* set increase font button with Arial font, no emphasis and size 20 */
        increaseFont = new JButton("Increase Font Size");
        increaseFont.setFont(new Font("Arial", Font.PLAIN, 20));
        background.add(increaseFont);
        /* register listeners for JButton */
        ButtonHandler buttonHandler = new ButtonHandler();
        decreaseFont.addActionListener(buttonHandler);
        increaseFont.addActionListener(buttonHandler);

        /* set change background color button with Arial font, no emphasis and size 20 */
        changeBackgroundColor = new JButton("Select Background Color");
        changeBackgroundColor.setFont(new Font("Arial", Font.PLAIN, 20));
        background.add(changeBackgroundColor);
        changeBackgroundColor.addActionListener(
                new ActionListener() // anonymous inner class
                {
                    /* display JColorChooser when user clicks button */
                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                        Color previousColor = backgroundColor;
                        backgroundColor = JColorChooser.showDialog(LargeTypeDisplay.this,
                                                                    "Choose a background color", backgroundColor);

                        // set background color with previous background color if no color is returned
                        if (backgroundColor == null)
                            backgroundColor = previousColor;

                        // change background panel to selected background color
                        background.setBackground(backgroundColor);
                    }
                }
        );

        /* set change font color button with Arial font, no emphasis and size 20 */
        changeFontColor = new JButton("Select Font Color");
        changeFontColor.setFont(new Font("Arial", Font.PLAIN, 20));
        background.add(changeFontColor);
        changeFontColor.addActionListener(
                new ActionListener() // anonymous inner class
                {
                    /* display JColorChooser when user clicks button */
                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                        Color previousColor = fontColor;
                        fontColor = JColorChooser.showDialog(LargeTypeDisplay.this,
                                                                "Choose a background color", fontColor);

                        // set font color with previous font color if no color is returned
                        if (fontColor == null)
                            fontColor = previousColor;

                        // change textArea font color to selected font color
                        textArea.setForeground(fontColor);
                    }
                }
        );

        /* set select font combobox with Arial font, no emphasis and size 20 */
        selectFont = new JComboBox<>(fonts);
        selectFont.setFont(new Font("Arial", Font.PLAIN, 20));
        selectFont.setMaximumRowCount(3); // display three rows
        background.add(selectFont);
        selectFont.addItemListener(
                new ItemListener() // anonymous inner class
                {
                    /* handle list selection events */
                    @Override
                    public void itemStateChanged(ItemEvent event)
                    {
                        // change textArea font style to selected font
                        if (event.getStateChange() == ItemEvent.SELECTED)
                            textArea.setFont(new Font(fonts[selectFont.getSelectedIndex()], fontEmphasis, fontSize));
                    }
                }
        );

        /* set bold checkbox with Arial font, no emphasis and size 20 */
        boldCheckBox = new JCheckBox("Bold");
        boldCheckBox.setFont(new Font("Arial", Font.PLAIN, 20));
        background.add(boldCheckBox);
        /* register listeners for JCheckBox */
        CheckBoxHandler checkBoxHandler = new CheckBoxHandler();
        boldCheckBox.addItemListener(checkBoxHandler);

        /*
         * set textArea with 10 rows and 35 columns
         * and set default text font to Serif, no emphasis and size 18
         */
        textArea = new JTextArea(8,35);
        textArea.setFont(new Font("Serif", Font.PLAIN, fontSize));
        textArea.setLineWrap(true); // sets the line-wrapping policy of the text area.
        textArea.setWrapStyleWord(true); // sets the style of wrapping used if the text area is wrapping lines.
        /* add textArea to JScrollPane */
        JScrollPane textScroller = new JScrollPane(textArea);
        background.add(textScroller);

        /* add everything to the JPanel */
        add(background);
    }

    /**
     * private inner class for ActionListener event handling
     */
    private class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            Font font = null;

             /* determine which button is selected */
            if (event.getSource() == decreaseFont)
            {
                if (fontSize == 18) // smallest font size
                {
                    fontSize = 19;
                    JLabel label = new JLabel("YOU HAVE REACHED THE SMALLEST FONT SIZE ");
                    label.setFont(new Font("Arial", Font.PLAIN, 20));
                    JOptionPane.showMessageDialog(null, label,
                            "MESSAGE", JOptionPane.WARNING_MESSAGE);
                }
                font = new Font(fonts[selectFont.getSelectedIndex()], fontEmphasis, fontSize -= 1);
            }
            else if (event.getSource() == increaseFont)
                font = new Font(fonts[selectFont.getSelectedIndex()], fontEmphasis, fontSize += 1);

            textArea.setFont(font);
        }
    }

    /**
     * private inner class for ItemListener event handling
     */
    private class CheckBoxHandler implements ItemListener
    {
        @Override
        public void itemStateChanged(ItemEvent event)
        {
            Font font;

            /* determine which checkbox is selected */
            if (boldCheckBox.isSelected())
            {
                font = new Font(fonts[selectFont.getSelectedIndex()], Font.BOLD, fontSize);
                fontEmphasis = Font.BOLD; // maintain the font emphasis while performing other action
            }
            else
            {
                font = new Font(fonts[selectFont.getSelectedIndex()], Font.PLAIN, fontSize);
                 fontEmphasis= Font.PLAIN; // maintain the font emphasis while performing other action
            }

            textArea.setFont(font);
        }
    }
}
