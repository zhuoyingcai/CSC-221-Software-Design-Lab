import java.awt.*;

public class MyLine extends MyShape
{
    /**
     * This is the default constructor.
     */
    public MyLine()
    {
        super();
    }

    /**
     * Class constructor that initialized all the coordinates and color of a line.
     * @param x1    This is the x in the first coordinate.
     * @param y1    This is the y in the first coordinate.
     * @param x2    This is the x in the second coordinate.
     * @param y2    This is the y in the second coordinate.
     * @param color This is the color of the shape.
     */
    public MyLine(int x1, int y1, int x2, int y2, Color color)
    {
        super(x1, y1, x2, y2, color);
    }

    /**
     * {@inheritDoc}
     * This method overrides the draw method from the MyShape superclass for a line.
     * @param g This is the graphic.
     */
    @Override
    public void draw(Graphics g)
    {
        g.setColor(getColor());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }
}