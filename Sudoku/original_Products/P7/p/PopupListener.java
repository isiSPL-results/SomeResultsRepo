package p;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;


public class PopupListener extends MouseAdapter
{
    private JPopupMenu menu;


    public PopupListener(JPopupMenu popupMenu)
    {
        this.menu = popupMenu;
    }


    public void mousePressed(MouseEvent e)
    {
        menu.show(e.getComponent(), e.getX(), e.getY());
    }


    public void mouseReleased(MouseEvent e)
    {
    }
}
