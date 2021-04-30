
//#if -1625110687
// Compilation Unit of /PopupListener.java


//#if 1072306967
package p;
//#endif


//#if 1245219264
import java.awt.event.MouseAdapter;
//#endif


//#if -90910507
import java.awt.event.MouseEvent;
//#endif


//#if 1942899539
import javax.swing.JPopupMenu;
//#endif


//#if 207434187
public class PopupListener extends
//#if -117836482
    MouseAdapter
//#endif

{

//#if -697302612
    private JPopupMenu menu;
//#endif


//#if 628022852
    public PopupListener(JPopupMenu popupMenu)
    {

//#if 1546654524
        this.menu = popupMenu;
//#endif

    }

//#endif


//#if 1375206928
    public void mouseReleased(MouseEvent e)
    {
    }
//#endif


//#if 1961002547
    public void mousePressed(MouseEvent e)
    {

//#if 310478999
        menu.show(e.getComponent(), e.getX(), e.getY());
//#endif

    }

//#endif

}

//#endif


//#endif

