import java.awt.*;

public class MyOval extends MyBoundedShape
{
    /**
     * This is the default constructor.
     */
    public MyOval()
    {
        super();
    }

    /**
     * Class constructor that initialized all the coordinates and color of an oval.
     * @param x1        This is the x in the first coordinate.
     * @param y1        This is the y in the first coordinate.
     * @param x2        This is the x in the second coordinate.
     * @param y2        This is the y in the second coordinate.
     * @param color     This is the color of the shape.
     * @param filled    Determined if the shape is filled or not.
     */
    public MyOval(int x1, int y1, int x2, int y2, Color color, boolean filled)
    {
        super(x1, y1, x2, y2, color, filled);
    }

    /**
     * {@inheritDoc}
     * This method overrides the draw method from the MyShape superclass for an oval.
     * @param g This is the graphic.
     */
    @Override
    public void draw(Graphics g)
    {
        g.setColor(getColor());

        if (filled)
            g.fillOval(coorX(), coorY(), width(), height());
        else
            g.drawOval(coorX(), coorY(), width(), height());
    }
}
