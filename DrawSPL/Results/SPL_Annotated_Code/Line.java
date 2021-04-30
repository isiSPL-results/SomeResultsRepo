// Compilation Unit of /Line.java


//#if  LINE
import java.awt.*;
//#endif


//#if  LINE
public class Line
{
    private Point startPoint;
    private Point endPoint ;

//#if  ( COLOR  &&  BASE  &&  LINE )
    private Color color;
//#endif

    public Point getStart()
    {
        return startPoint;
    }

    public Point getEnd ()
    {
        return endPoint;
    }


//#if  ( COLOR  &&  BASE  &&  LINE )
    public Line(Color color,
                Point start)
    {
        startPoint = start;
        this.color = color;
    }

//#endif

    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);

//#if  ( COLOR  &&  BASE  &&  LINE )
        g.setColor(color);
//#endif

        g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }


//#if  ( LINE  &&  BASE ) && ! COLOR
    public Line(
        Point start)
    {
        startPoint = start;
    }

//#endif

    public void setEnd(Point end)
    {
        endPoint = end;
    }

}

//#endif


