/**
 * MyShape Hierarchy
 */

import java.awt.*;
import java.io.Serializable;

public abstract class MyShape implements Serializable
{
    protected int x1, y1, x2, y2; // coordinates of two points.
    protected Color color;  // color of the shape.

    /**
     * Class constructor that initialized all the coordinates to 0
     * and default the shape color to black.
     */
    public MyShape()
    {
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;
        color = Color.BLACK;
    }

    /**
     * Class constructor that initialized all the coordinates and color of a shape.
     * @param x1    This is the x in the first coordinate.
     * @param y1    This is the y in the first coordinate.
     * @param x2    This is the x in the second coordinate.
     * @param y2    This is the y in the second coordinate.
     * @param color This is the color of the shape.
     */
    public MyShape(int x1, int y1, int x2, int y2, Color color)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    /**
     * This method is used to set the x in the first coordinate.
     * @param x1 This is the x in the first coordinate.
     */
    public void setX1(int x1) { this.x1 = x1; }

    /**
     * This method is used to set the y in the first coordinate.
     * @param y1 This is y in the first coordinate.
     */
    public void setY1(int y1) { this.y1 = y1; }

    /**
     * This method is used to set the x in the second coordinate.
     * @param x2 This is the x in the second coordinate.
     */
    public void setX2(int x2) { this.x2 = x2; }

    /**
     * This method is used to set the y in the second coordinate.
     * @param y2 This is the y in the second coordinate.
     */
    public void setY2(int y2) { this.y2 = y2; }

    /**
     * This method is used to set the color of the shape.
     * @param color This is the color of the shape.
     */
    public void setColor(Color color) { this.color = color; }

    /**
     * This method is used to retrieve x in the first coordinate.
     * @return int This returns x in the first coordinate.
     */
    public int getX1() { return x1; }

    /**
     * This method is used to retrieve y in the first coordinate.
     * @return int This returns y in the first coordinate.
     */
    public int getY1() { return y1; }

    /**
     * This method is used to retrieve x in the second coordinate.
     * @return int This returns x in the second coordinate.
     */
    public int getX2() { return x2; }

    /**
     * This method is used to retrieve y in the second coordinate.
     * @return int This returns y in the second coordinate.
     */
    public int getY2() { return y2; }

    /**
     * This method is used to retrieve the color of the shape.
     * @return Color This returns the color of the shape.
     */
    public Color getColor() { return color; }

    /**
     * Allow concrete classes override this method.
     * @param g This is the graphic.
     */
    public abstract void draw(Graphics g);
}
