import java.awt.Graphics;
import java.awt.Color;
public class Rectangle
{
    private int x, y, width, height ;
    private int dx, dy;
    private int x2, y2;
    private Color color;
    /** Called after rectangle is drawn.
    	 *  Adjusts the coordinate values of x and y
    	 */
    public void updateCorner()
    {
        int cornerX = x, cornerY = y;
        if(dy < 0) { //1
            if(dx >=0) { //1
                cornerX = x;
                cornerY = y2;
            } else {
                cornerX = x2;
                cornerY = y2;
            }
        } else {
            if(dx >=0) { //1
                cornerX = x;
                cornerY = y;
            } else {
                cornerX = x2;
                cornerY = y;
            }
        }
        x = cornerX;
        y = cornerY;
    }
    /**
    	 * Called when the component Canvas is repainted
    	 * @param g
    	 */
    public void paint(Graphics g)
    {
        int cornerX = x, cornerY = y;
        if(dy < 0) { //1
            if(dx >=0) { //1
                cornerX = x;
                cornerY = y2;
            } else {
                cornerX = x2;
                cornerY = y2;
            }
        } else {
            if(dx >=0) { //1
                cornerX = x;
                cornerY = y;
            } else {
                cornerX = x2;
                cornerY = y;
            }
        }
        g.setColor(color);
        g.drawRect(cornerX, cornerY, width, height);
    }
    public void setEnd(int newX, int newY)
    {
        width = StrictMath.abs(newX-x);
        height = StrictMath.abs(newY-y);
        dx = newX - x;
        dy = newY - y;
        x2 = newX;
        y2 = newY;
    }
    public int getHeight()
    {
        return height;
    }
    public int getX()
    {
        return x;
    }
    public Rectangle(

        Color color,

        int x, int y)
    {
        this.color = color;
        this.x = x;
        this.y = y;
    }
    public int getWidth()
    {
        return width;
    }
    public int getY()
    {
        return y;
    }

}
