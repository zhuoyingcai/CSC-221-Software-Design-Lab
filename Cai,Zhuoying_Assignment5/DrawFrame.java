/**
 * Draw Frame for the Draw Panel.
 *
 * @author Zhuoying Cai
 * @since 11-20-2017
 */
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;

public class DrawFrame extends JFrame
{
    private JButton undo;
    private JButton clearAll;
    private JComboBox<String> selectShape;
    private static final String[] shapes = {"Line", "Rectangle", "Oval"};
    private JComboBox<String> selectColor;
    private static final String[] colorNames = {"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green",
                                            "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};
    private static final Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
                                            Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};

    private JCheckBox filledCheckBox;
    private JButton moreColor;
    private DrawPanel drawPanel;
    private JLabel statusLabel = new JLabel();
    private Color shapeColor = Color.BLACK;

    /**
     * Class constructor a draw frame.
     */
    public DrawFrame()
    {
        super("Java Drawings");

        setLayout(new BorderLayout());

        // JMenu for file
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');

        // JMenuItem for load
        JMenuItem loadItem = new JMenuItem("Open");
        loadItem.setMnemonic('O');
        fileMenu.add(loadItem);
        loadItem.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                        Path path = getLoadPath();
                        if (path != null)
                        {
                            LoadFile.openFile(path);
                            drawPanel.load(LoadFile.readRecords());
                            LoadFile.closeFile();
                        }
                    }
                }
        );

        // JMenuItem for save.
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.setMnemonic('S');
        fileMenu.add(saveItem);
        saveItem.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                        Path path = getSavePath();
                        if (path != null)
                        {
                            SaveFile.openFile(path);
                            SaveFile.addRecords(drawPanel.getMyShape());
                            SaveFile.closeFile();
                        }
                    }
                }
        );

        fileMenu.addSeparator();

        // JMenuItem for exit.
        JMenuItem existItem = new JMenuItem("Exit");
        existItem.setMnemonic('X');
        fileMenu.add(existItem);
        existItem.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                        int result = JOptionPane.showConfirmDialog(null, "Do you want to save your drawing?");
                        if (result == JOptionPane.YES_OPTION)
                        {
                            Path path = getSavePath();
                            if (path != null)
                            {
                                SaveFile.openFile(path);
                                SaveFile.addRecords(drawPanel.getMyShape());
                                SaveFile.closeFile();
                            }
                        }
                        if (result == JOptionPane.NO_OPTION)
                        {
                            System.exit(0);
                        }
                    }
                }
        );

        // Add JMenBar to JFrame
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(fileMenu);

        // Add another JPanel to organize the button.
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // JButton
        undo = new JButton("Undo");
        clearAll = new JButton("Clear");

        ButtonHandler buttonHandler = new ButtonHandler();
        undo.addActionListener(buttonHandler);
        clearAll.addActionListener(buttonHandler);

        // JComboBox for shapes
        selectShape = new JComboBox<>(shapes);
        selectShape.setMaximumRowCount(3);
        selectShape.addItemListener(
                new ItemListener()
                {
                    @Override
                    public void itemStateChanged(ItemEvent event)
                    {
                        if (event.getStateChange() == ItemEvent.SELECTED)
                            drawPanel.setShapeType(selectShape.getSelectedIndex());
                    }
                }
        );

        // JComboBox for colors
        selectColor = new JComboBox<>(colorNames);
        selectColor.setMaximumRowCount(6);
        selectColor.addItemListener(
                new ItemListener()
                {
                    @Override
                    public void itemStateChanged(ItemEvent event)
                    {
                        if (event.getStateChange() == ItemEvent.SELECTED)
                            drawPanel.setCurrentColor(colors[selectColor.getSelectedIndex()]);
                    }
                }
        );

        // JColorChooser to select more colors
        moreColor = new JButton("More Colors");
        moreColor.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        Color previousColor = drawPanel.getCurrentColor();

                        shapeColor = JColorChooser.showDialog(DrawFrame.this,"Choose color", shapeColor);

                        if (shapeColor == null)
                            shapeColor = previousColor;

                        drawPanel.setCurrentColor(shapeColor);
                    }
                }
        );

        // JCheckBox for filled box
        filledCheckBox = new JCheckBox("Filled");
        CheckBoxHandler checkBoxHandler = new CheckBoxHandler();
        filledCheckBox.addItemListener(checkBoxHandler);

        // add all components to the panel.
        panel.add(clearAll);
        panel.add(undo);
        panel.add(selectShape);
        panel.add(selectColor);
        panel.add(moreColor);
        panel.add(filledCheckBox);

        // add the panel to the JFrame.
        add(panel,BorderLayout.NORTH);

        // Second panel for the DrawPanel.
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,1));

        drawPanel = new DrawPanel(statusLabel);
        panel2.add(drawPanel);

        // set the panel2 at the center of the JFrame.
        add(panel2, BorderLayout.CENTER);


        statusLabel.setFont(new Font("Arial",Font.PLAIN,15));

        // add statusLabel at the south of the JFrame.
        add(statusLabel, BorderLayout.SOUTH);

        // addWindowListener when user closed the window, prompt if want to save the drawing
        addWindowListener(
                new WindowAdapter()
                {
                    @Override
                    public void windowClosing(WindowEvent event)
                    {
                        int result = JOptionPane.showConfirmDialog(null, "Do you want to save your drawing?");

                        if (result == JOptionPane.YES_OPTION)
                        {
                            Path path = getSavePath();
                            if (path != null)
                            {
                                SaveFile.openFile(path);
                                SaveFile.addRecords(drawPanel.getMyShape());
                                SaveFile.closeFile();
                            }
                        }
                        if (result == JOptionPane.NO_OPTION)
                        {
                            System.exit(0);
                        }
                    }
                }
        );
    }

    /**
     * Private function to get the path for save file
     * @return Path This returns the path
     */
    private Path getSavePath()
    {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Java Drawings (.ser)","ser");
        fileChooser.setFileFilter(filter); // set file extension with .ser
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int result = fileChooser.showSaveDialog(this);

        if (result == JFileChooser.CANCEL_OPTION)
        {
            fileChooser.cancelSelection();
            return null;
        }

        return fileChooser.getSelectedFile().toPath();
    }

    /**
     * Private function to get the path for load file
     * @return Path This returns the path
     */
    public Path getLoadPath()
    {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Java Drawings (.ser)","ser");
        fileChooser.setFileFilter(filter); // set file extension with .ser

        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.CANCEL_OPTION)
        {
            fileChooser.cancelSelection();
            return null;
        }

        return fileChooser.getSelectedFile().toPath();
    }

    private class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            // if undo is clicked
            if (event.getSource() == undo)
                drawPanel.clearLastShape();
            // if clear is clicked
            else if (event.getSource() == clearAll)
                drawPanel.clearDrawing();
        }
    }

    private class CheckBoxHandler implements ItemListener
    {
        @Override
        public void itemStateChanged(ItemEvent event)
        {
            // if filled checkbox is selected
            if (filledCheckBox.isSelected())
                drawPanel.setFilledShape(true);
            else
                drawPanel.setFilledShape(false);
        }
    }
}
