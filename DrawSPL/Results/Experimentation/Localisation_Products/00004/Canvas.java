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
        }
    }
    public void mouseEntered(MouseEvent e)
    {
    }/** Invoked when a mouse button has been released on a component. */
    public void mouseReleased(MouseEvent e)
    {
        switch(figureSelected) { //1
        }
    }
    public void mouseMoved(MouseEvent e)
    {
    }/** Invoked when the mouse exits a component. Empty implementation.
	 * Do not change. */
    public void mouseExited(MouseEvent e)
    {
    }/** Paints the component in turn. Call whenever repaint is called. */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
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
        this.repaint();
    }
    /** Invoked when the mouse is dragged over a component */
    public void mouseDragged(MouseEvent e)
    {
        switch(figureSelected) { //1
        }
    }
    public enum FigureTypes {
        NONE,

        ;
    }

}
