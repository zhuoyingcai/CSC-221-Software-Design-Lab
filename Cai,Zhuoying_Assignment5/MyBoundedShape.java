import java.awt.*;

public abstract class MyBoundedShape extends MyShape
{
    protected boolean filled;

    /**
     * This is the default constructor.
     */
    public MyBoundedShape()
    {
        super();
        filled = false;
    }

    /**
     * Class constructor that initialized all the coordinates and color of a bounded shape.
     * @param x1        This is the x in the first coordinate.
     * @param y1        This is the y in the first coordinate.
     * @param x2        This is the x in the second coordinate.
     * @param y2        This is the y in the second coordinate.
     * @param color     This is the color of the shape.
     * @param filled    Determined if the shape is filled or not.
     */
    public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean filled)
    {
        super(x1, y1, x2, y2, color);
        this.filled = filled;
    }

    /**
     * This method determined the upper-left x coordinate of the bounded shape.
     * @return int This returns the upper-left x coordinate of the bounded shape.
     */
    public int coorX() { return Math.min(x1, x2); }

    /**
     * This method determined the upper-left 7 coordinate of the bounded shape.
     * @return int This returns the upper-left y coordinate of the bounded shape.
     */
    public int coorY() { return Math.min(y1, y2); }

    /**
     * This method calculates the width of the bounded shape.
     * @return int This returns the width of the bounded shape.
     */
    public int width()
    {
        return Math.abs(x1 - x2);
    }

    /**
     * This method calculates the height of the bounded shape.
     * @return int This returns the height of the bounded shape.
     */
    public int height()
    {
        return Math.abs(getY1() - getY2());
    }

    /**
     * This method sets the bounded shape to be filled or not.
     * @param filled This sets the bounded shape to be filled or not.
     */
    public void setFilled(boolean filled) { this.filled = filled; }

    /**
     * This method retrives if the bounded shape is filled or not
     * @return boolean
     */
    public boolean getFilled() { return filled; }
}
