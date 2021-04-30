import java.awt.*;
public class Line
{
    private Point startPoint;
    private Point endPoint ;
    private Color color;
    public Point getStart()
    {
        return startPoint;
    }
    public Point getEnd ()
    {
        return endPoint;
    }
    public Line(Color color,
                Point start)
    {
        startPoint = start;
        this.color = color;
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.setColor(color);
        g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }
    public void setEnd(Point end)
    {
        endPoint = end;
    }

}
