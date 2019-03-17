/**
 * Draw Panel for myShape
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class DrawPanel extends JPanel
{
    private ArrayList<MyShape> myShape; // store all the shapes the user draws
    private int shapeType; // determines the type of shape to draw
    private MyShape currentShape; // current shape the user is drawing
    private Color currentColor; // current drawing color
    private boolean filledShape; //whether to draw a filled shape
    private JLabel statusLabel; // status bar

    /**
     * This class constructor initialized an empty arraylist,
     * default shape type to a line, current shape to null, current color to black,
     * and background to white.
     * @param statusLabel This is the coordinates of the mouse.
     */
    public DrawPanel(JLabel statusLabel)
    {
        this.statusLabel = statusLabel;

        myShape = new ArrayList<>();
        shapeType = 0;
        currentShape = null;
        currentColor = Color.BLACK;

        setBackground(Color.WHITE);

        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
    }

    /**
     * This method overrides the paintComponent from the Object superclass.
     * @param g This is the graphic.
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for(MyShape shape : myShape)
        {
            shape.draw(g);
        }
    }

    /**
     * Private inner class for MouseHandler event handling
     */
    private class MouseHandler extends MouseAdapter implements MouseMotionListener
    {
        @Override
        public void mousePressed(MouseEvent event)
        {
            // Select shape
            if (shapeType == 0)
                currentShape = new MyLine();
            else if (shapeType == 1)
                currentShape = new MyRectangle();
            else if (shapeType == 2)
                currentShape = new MyOval();

            // set the first coordinate of the shape when the mouse is clicked on the panel.
            currentShape.setX1(event.getX());
            currentShape.setY1(event.getY());
            currentShape.setColor(currentColor);

            // if filled option is selected
            if (currentShape instanceof MyBoundedShape)
                ((MyBoundedShape)currentShape).setFilled(filledShape);

            // add the shape that is currently drawing to the arraylist.
            myShape.add(currentShape);
        }

        @Override
        public void mouseReleased(MouseEvent event)
        {
            // set the second coordinate of the shape when the mouse is released on the panel.
            currentShape.setX2(event.getX());
            currentShape.setY2(event.getY());

            repaint();

            currentShape = null;
        }

        @Override
        public void mouseMoved(MouseEvent event)
        {
            // show coordinate when the mouse is moving
            statusLabel.setText(String.format("[%d, %d]", event.getX(), event.getY()));
        }

        @Override
        public void mouseDragged(MouseEvent event)
        {
            // set the coordinates of the shape when the mouse is dragged on the panel.
            currentShape.setX2(event.getX());
            currentShape.setY2(event.getY());

            repaint();

            statusLabel.setText(String.format("[%d, %d]", event.getX(), event.getY()));
        }

        @Override
        public void mouseEntered(MouseEvent event)
        {
            // show the coordinate when the mouse first enter the panel.
            statusLabel.setText(String.format("[%d, %d]", event.getX(), event.getY()));
        }
    }

    /**
     * This method is used to set the shape type.
     * @param shapeType This is shape type.
     */
    public void setShapeType(int shapeType)
    {
        this.shapeType = shapeType;
    }

    /**
     * This method is used to set the color of the shape.
     * @param color This is the color of the shape.
     */
    public void setCurrentColor(Color color)
    {
        this.currentColor = color;
    }

    /**
     * This method is used to set the whether if the shape is filled.
     * @param filledShape This determines whether the shape is filled.
     */
    public void setFilledShape(boolean filledShape)
    {
        this.filledShape = filledShape;
    }

    /**
     * This method is used to retrieve shape arraylist.
     * @return ArrayList<MyShape> This returns the ArrayList.
     */
    public ArrayList<MyShape> getMyShape() { return myShape; }

    /**
     * This method is used to retrieve the color of the shape.
     * @return Color This returns the color of the shape.
     */
    public Color getCurrentColor() { return currentColor; }

    /**
     * This method is used to undo the drawing on the panel.
     */
    public void clearLastShape()
    {
        if (myShape.size() > 0)
            myShape.remove(myShape.size() - 1);

        repaint();
    }

    /**
     * This method is used clear the drawing on the panel.
     */
    public void clearDrawing()
    {
        myShape.clear();

        repaint();
    }

    /**
     * This method is used to load all the shapes in the array on the panel.
     * @param input
     */
    public void load(ArrayList<MyShape> input)
    {
        myShape = input;
        repaint();
    }
}