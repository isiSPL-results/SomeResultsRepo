// Compilation Unit of /Canvas.java

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.*;
import java.awt.event.*;
import javax.swing.JComponent;
import java.awt.Point;
import java.awt.Color;
@SuppressWarnings("serial")
public class Canvas extends JComponent
    implements MouseListener
    , MouseMotionListener
{

//#if  LINE
    protected List<Line> lines = new LinkedList<Line>();
//#endif

    Point start, end;

//#if  LINE
    protected Line newLine = null;
//#endif

    public FigureTypes figureSelected = FigureTypes.NONE;
    protected Color color = Color.BLACK;

//#if  RECT
    protected List<Rectangle> rects = new LinkedList<Rectangle>();
//#endif


//#if  RECT
    protected Rectangle newRect = null;
//#endif


//#if  RECT
    /** Clears the reference to the new line */
    public void mouseReleasedRect(MouseEvent e)
    {
        newRect = null;
    }

//#endif

    /** Sets up the canvas. Do not change */
    public Canvas()
    {
        this.setDoubleBuffered(true);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }


//#if  LINE
    public void mousePressedLine(MouseEvent e)
    {
        if(newLine == null) { //1
            start = new Point(e.getX(), e.getY());

//#if  ( LINE  &&  BASE ) && ! COLOR
            newLine = new Line (

                start);
//#endif


//#if  ( COLOR  &&  BASE  &&  LINE )
            newLine = new Line (
                color,
                start);
//#endif

            lines.add(newLine);
        }

    }

//#endif

    /** Invoked when a mouse button has been pressed on a component. */
    public void mousePressed(MouseEvent e)
    {
        switch(figureSelected) { //1
        case LINE ://1


//#if  LINE
            mousePressedLine(e);
//#endif


//#if  LINE
            break;

//#endif


        case RECT://1


//#if  RECT
            mousePressedRect(e);
//#endif


//#if  RECT
            break;

//#endif


        }

    }


//#if  LINE
    /** Updates the end point coordinates and repaints figure */
    public void mouseDraggedLine(MouseEvent e)
    {
        newLine.setEnd(new Point(e.getX(), e.getY()));
        repaint();
    }

//#endif

    public void mouseEntered(MouseEvent e)
    {
    }

//#if  RECT
    public void mousePressedRect(MouseEvent e)
    {
        if(newRect == null) { //1

//#if  ( RECT  &&  BASE ) && ! COLOR
            newRect = new Rectangle (

                e.getX(), e.getY());
//#endif


//#if  ( COLOR  &&  BASE  &&  RECT )
            newRect = new Rectangle (
                color,
                e.getX(), e.getY());
//#endif

            rects.add(newRect);
        }

    }

//#endif

    /** Invoked when a mouse button has been released on a component. */
    public void mouseReleased(MouseEvent e)
    {
        switch(figureSelected) { //1
        case LINE ://1


//#if  LINE
            mouseReleasedLine(e);
//#endif


//#if  LINE
            break;

//#endif


        case RECT://1


//#if  RECT
            mouseReleasedRect(e);
//#endif


//#if  RECT
            break;

//#endif


        }

    }

    public void mouseMoved(MouseEvent e)
    {
    }
    /** Invoked when the mouse exits a component. Empty implementation.
    	 * Do not change. */
    public void mouseExited(MouseEvent e)
    {
    }

//#if  RECT
    /** Updates the end point coordinates and repaints figure */
    public void mouseDraggedRect(MouseEvent e)
    {
        newRect.setEnd(e.getX(), e.getY());
        repaint();
    }

//#endif

    /** Paints the component in turn. Call whenever repaint is called. */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

//#if  LINE
        for (Line l : lines) { //1
            l.paint(g);
        }

//#endif


//#if  RECT
        for (Rectangle r: rects) { //1
            r.paint(g);
        }

//#endif

    }


//#if  LINE
    /** Clears the reference to the new line */
    public void mouseReleasedLine(MouseEvent e)
    {
        newLine = null;
    }

//#endif

    public void mouseClicked(MouseEvent e)
    {
    }
    /** Sets the selected figure. Do not change. */
    public void selectedFigure(FigureTypes fig)
    {
        figureSelected = fig;
    }


//#if  COLOR
    public void setColor(String colorString)
    {
        if(colorString.equals("Red")) { //1
            color = Color.red;
        } else

//#if  COLOR
            if(colorString.equals("Green")) { //1
                color = Color.green;
            } else

//#if  COLOR
                if(colorString.equals("Blue")) { //1
                    color = Color.blue;
                } else {
                    color = Color.black;
                }

//#endif


//#endif


    }

//#endif


//#if  WIPE
    public void wipe()
    {

//#if  ( WIPE  &&  BASE  &&  LINE )
        this.lines.clear();
//#endif


//#if  ( WIPE  &&  BASE  &&  RECT )
        this.rects.clear();
//#endif

        this.repaint();
    }

//#endif

    /** Invoked when the mouse is dragged over a component */
    public void mouseDragged(MouseEvent e)
    {
        switch(figureSelected) { //1
        case LINE ://1


//#if  LINE
            mouseDraggedLine(e);
//#endif


//#if  LINE
            break;

//#endif


        case RECT://1


//#if  RECT
            mouseDraggedRect(e);
//#endif


//#if  RECT
            break;

//#endif


        }

    }

    public enum FigureTypes {
        NONE,


//#if  LINE
        LINE,

//#endif


//#if  RECT
        RECT,

//#endif

        ;
    }

}


