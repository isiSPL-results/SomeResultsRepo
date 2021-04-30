
//#if -108249419
// Compilation Unit of /Line.java


//#if 1341196663
import java.awt.*;
//#endif


//#if 1438174130
public class Line
{

//#if 92698680
    private Point startPoint;
//#endif


//#if -2001214287
    private Point endPoint ;
//#endif


//#if -372112032
    private Color color;
//#endif


//#if 1164886796
    public Point getStart()
    {

//#if 320054500
        return startPoint;
//#endif

    }

//#endif


//#if 1959052165
    public Point getEnd ()
    {

//#if 320689744
        return endPoint;
//#endif

    }

//#endif


//#if 1801340366
    public Line(Color color,
                Point start)
    {

//#if -1062785062
        startPoint = start;
//#endif


//#if 257859476
        this.color = color;
//#endif

    }

//#endif


//#if -432587364
    public void paint(Graphics g)
    {

//#if -1519653934
        g.setColor(Color.BLACK);
//#endif


//#if -1552259327
        g.setColor(color);
//#endif


//#if 729371107
        g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
//#endif

    }

//#endif


//#if 1676115796
    public Line(
        Point start)
    {

//#if -1776798838
        startPoint = start;
//#endif

    }

//#endif


//#if 741897428
    public void setEnd(Point end)
    {

//#if -786208492
        endPoint = end;
//#endif

    }

//#endif

}

//#endif


//#endif

