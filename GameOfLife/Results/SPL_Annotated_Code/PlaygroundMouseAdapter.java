
//#if  PopUpMenu
// Compilation Unit of /PlaygroundMouseAdapter.java


//#if  PopUpMenu
import java.awt.Color;
//#endif


//#if  PopUpMenu
import java.awt.Dimension;
//#endif


//#if  PopUpMenu
import java.awt.Graphics;
//#endif


//#if  PopUpMenu
import java.awt.event.MouseAdapter;
//#endif


//#if  PopUpMenu
import java.awt.event.MouseEvent;
//#endif


//#if  PopUpMenu
import javax.swing.JPanel;
//#endif


//#if  PopUpMenu
import javax.swing.JPopupMenu;
//#endif

class PlaygroundMouseAdapter
{
    public boolean hook(MouseEvent e, int x, int y)
    {
        if(e.isPopupTrigger() || e.getButton()==MouseEvent.BUTTON3) { //1
            JPopupMenu popup = new PopUpMenu(playgroundPanel.getModel(), x, y);
            popup.show(playgroundPanel,
                       e.getX(), e.getY());
            return true;
        } else {
            return false;
        }

    }

}


//#endif

