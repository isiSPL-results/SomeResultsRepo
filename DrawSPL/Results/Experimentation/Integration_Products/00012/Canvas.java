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
    ,MouseMotionListener
{
    Point start, end;
    public FigureTypes figureSelected = FigureTypes.NONE;
    protected Color color = Color.BLACK;
    protected List<Rectangle> rects = new LinkedList<Rectangle>();
    protected Rectangle newRect = null;
    /** Clears the reference to the new line */
    public void mouseReleasedRect(MouseEvent e)
    {
        newRect = null;
    }
    /** Sets up the canvas. Do not change */
    public Canvas()
    {
        this.setDoubleBuffered(true);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    /** Invoked when a mouse button has been pressed on a component. */
    public void mousePressed(MouseEvent e)
    {
        switch(figureSelected) { //1
        case RECT://1

            mousePressedRect(e);
            break;


        }
    }
    public void mouseEntered(MouseEvent e)
    {
    } public void mousePressedRect(MouseEvent e)
    {
        if(newRect == null) { //1
            newRect = new Rectangle (

                e.getX(), e.getY());
            rects.add(newRect);
        }
    }
    /** Invoked when a mouse button has been released on a component. */
    public void mouseReleased(MouseEvent e)
    {
        switch(figureSelected) { //1
        case RECT://1

            mouseReleasedRect(e);
            break;


        }
    }
    public void mouseMoved(MouseEvent e)
    {
    }/** Invoked when the mouse exits a component. Empty implementation.
	 * Do not change. */
    public void mouseExited(MouseEvent e)
    {
    }/** Updates the end point coordinates and repaints figure */
    public void mouseDraggedRect(MouseEvent e)
    {
        newRect.setEnd(e.getX(), e.getY());
        repaint();
    }
    /** Paints the component in turn. Call whenever repaint is called. */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        for (Rectangle r: rects) { //1
            r.paint(g);
        }
    }
    public void mouseClicked(MouseEvent e)
    {
    }/** Sets the selected figure. Do not change. */
    public void selectedFigure(FigureTypes fig)
    {
        figureSelected = fig;
    }
    public void wipe()
    {
        this.rects.clear();
        this.repaint();
    }
    /** Invoked when the mouse is dragged over a component */
    public void mouseDragged(MouseEvent e)
    {
        switch(figureSelected) { //1
        case RECT://1

            mouseDraggedRect(e);
            break;


        }
    }
    public enum FigureTypes {
        NONE,

        RECT,

        ;
    }

}
