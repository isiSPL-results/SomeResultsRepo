import java.awt.*;
public class Line
{
    private Point startPoint;
    private Point endPoint ;
    public Point getStart()
    {
        return startPoint;
    }
    public Point getEnd ()
    {
        return endPoint;
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }
    public Line(
        Point start)
    {
        startPoint = start;
    }
    public void setEnd(Point end)
    {
        endPoint = end;
    }

}
