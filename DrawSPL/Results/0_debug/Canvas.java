
//#if -1395427241
// Compilation Unit of /Canvas.java


//#if -27984166
import java.awt.Graphics;
//#endif


//#if -1729125796
import java.awt.event.MouseEvent;
//#endif


//#if 1317594391
import java.util.*;
//#endif


//#if -2104941573
import java.awt.event.*;
//#endif


//#if -1681129318
import javax.swing.JComponent;
//#endif


//#if -1199691487
import java.awt.Point;
//#endif


//#if -1571780178
import java.awt.Color;
//#endif


//#if -1919020858

//#if -1596245097
@SuppressWarnings("serial")
//#endif

public class Canvas extends
//#if 923370813
    JComponent
//#endif

    implements
//#if -1895261521
    MouseListener
//#endif

    ,
//#if 1098252357
    MouseMotionListener
//#endif

{

//#if -1775940797
    protected List<Line> lines = new LinkedList<Line>();
//#endif


//#if 1444862992
    Point start, end;
//#endif


//#if 370717715
    protected Line newLine = null;
//#endif


//#if -2042761458
    public FigureTypes figureSelected = FigureTypes.NONE;
//#endif


//#if 1203506816
    protected Color color = Color.BLACK;
//#endif


//#if 853218703
    protected List<Rectangle> rects = new LinkedList<Rectangle>();
//#endif


//#if -1907779792
    protected Rectangle newRect = null;
//#endif


//#if 408306112
    /** Clears the reference to the new line */
    public void mouseReleasedRect(MouseEvent e)
    {

//#if 1698051735
        newRect = null;
//#endif

    }

//#endif


//#if -529211639
    /** Sets up the canvas. Do not change */
    public Canvas()
    {

//#if 1773378117
        this.setDoubleBuffered(true);
//#endif


//#if 1777714769
        this.addMouseListener(this);
//#endif


//#if -1149805061
        this.addMouseMotionListener(this);
//#endif

    }

//#endif


//#if -435520727
    public void mousePressedLine(MouseEvent e)
    {

//#if -1570176420
        if(newLine == null) { //1

//#if 1128028568
            start = new Point(e.getX(), e.getY());
//#endif


//#if 1414886721
            newLine = new Line (

                start);
//#endif


//#if -1889291720
            newLine = new Line (
                color,
                start);
//#endif


//#if 2022737466
            lines.add(newLine);
//#endif

        }

//#endif

    }

//#endif


//#if 1128975426
    /** Invoked when a mouse button has been pressed on a component. */
    public void mousePressed(MouseEvent e)
    {

//#if 1826808624
        switch(figureSelected) { //1
        case LINE ://1


//#if 1815666551
            mousePressedLine(e);
//#endif


//#if 1898373843
            break;

//#endif


        case RECT://1


//#if 1351145160
            mousePressedRect(e);
//#endif


//#if -1392560652
            break;

//#endif


        }

//#endif

    }

//#endif


//#if 532315541
    /** Updates the end point coordinates and repaints figure */
    public void mouseDraggedLine(MouseEvent e)
    {

//#if -514094730
        newLine.setEnd(new Point(e.getX(), e.getY()));
//#endif


//#if -517484780
        repaint();
//#endif

    }

//#endif


//#if 875064712
    public void mouseEntered(MouseEvent e)
    {
    }
//#endif


//#if -1555073223
    public void mousePressedRect(MouseEvent e)
    {

//#if 1627983544
        if(newRect == null) { //1

//#if -930572933
            newRect = new Rectangle (

                e.getX(), e.getY());
//#endif


//#if -1408759630
            newRect = new Rectangle (
                color,
                e.getX(), e.getY());
//#endif


//#if 82227700
            rects.add(newRect);
//#endif

        }

//#endif

    }

//#endif


//#if 1539360360
    /** Invoked when a mouse button has been released on a component. */
    public void mouseReleased(MouseEvent e)
    {

//#if 821854120
        switch(figureSelected) { //1
        case LINE ://1


//#if 570707408
            mouseReleasedLine(e);
//#endif


//#if -1989771023
            break;

//#endif


        case RECT://1


//#if -442778763
            mouseReleasedRect(e);
//#endif


//#if -941362724
            break;

//#endif


        }

//#endif

    }

//#endif


//#if 799868236
    public void mouseMoved(MouseEvent e)
    {
    }
//#endif


//#if 1646406528
    /** Invoked when the mouse exits a component. Empty implementation.
    	 * Do not change. */
    public void mouseExited(MouseEvent e)
    {
    }
//#endif


//#if -587236955
    /** Updates the end point coordinates and repaints figure */
    public void mouseDraggedRect(MouseEvent e)
    {

//#if 1899015299
        newRect.setEnd(e.getX(), e.getY());
//#endif


//#if 1632564120
        repaint();
//#endif

    }

//#endif


//#if -57234788
    /** Paints the component in turn. Call whenever repaint is called. */
    public void paintComponent(Graphics g)
    {

//#if 2047255218
        super.paintComponent(g);
//#endif


//#if -1051257889
        g.setColor(Color.WHITE);
//#endif


//#if -166562152
        g.fillRect(0, 0, getWidth(), getHeight());
//#endif


//#if -1605870793
        for (Line l : lines) { //1

//#if -1490696963
            l.paint(g);
//#endif

        }

//#endif


//#if -1301488050
        for (Rectangle r: rects) { //1

//#if -127915166
            r.paint(g);
//#endif

        }

//#endif

    }

//#endif


//#if 1527858608
    /** Clears the reference to the new line */
    public void mouseReleasedLine(MouseEvent e)
    {

//#if 1956454881
        newLine = null;
//#endif

    }

//#endif


//#if -1963296552
    public void mouseClicked(MouseEvent e)
    {
    }
//#endif


//#if 398749213
    /** Sets the selected figure. Do not change. */
    public void selectedFigure(FigureTypes fig)
    {

//#if -1711697198
        figureSelected = fig;
//#endif

    }

//#endif


//#if 2127557414
    public void setColor(String colorString)
    {

//#if 1921507418
        if(colorString.equals("Red")) { //1

//#if -1905943314
            color = Color.red;
//#endif

        } else

//#if 1716790074
            if(colorString.equals("Green")) { //1

//#if -2066486995
                color = Color.green;
//#endif

            } else

//#if -665283267
                if(colorString.equals("Blue")) { //1

//#if -1693653058
                    color = Color.blue;
//#endif

                } else {

//#if 1040984475
                    color = Color.black;
//#endif

                }

//#endif


//#endif


//#endif

    }

//#endif


//#if -1655672017
    public void wipe()
    {

//#if -1192800791
        this.lines.clear();
//#endif


//#if -1361949735
        this.rects.clear();
//#endif


//#if 489922012
        this.repaint();
//#endif

    }

//#endif


//#if 1314175503
    /** Invoked when the mouse is dragged over a component */
    public void mouseDragged(MouseEvent e)
    {

//#if 1865675862
        switch(figureSelected) { //1
        case LINE ://1


//#if -929054310
            mouseDraggedLine(e);
//#endif


//#if -777527098
            break;

//#endif


        case RECT://1


//#if 2067409561
            mouseDraggedRect(e);
//#endif


//#if 1365446165
            break;

//#endif


        }

//#endif

    }

//#endif


//#if 1620797850
    public enum FigureTypes {

//#if -1230614855
        NONE,

//#endif


//#if -1230680203
        LINE,

//#endif


//#if -1230505627
        RECT,

//#endif

        ;
    }

//#endif

}

//#endif


//#endif

