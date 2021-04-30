
//#if -915632687 
// Compilation Unit of /PlaygroundMouseAdapter.java 
 

//#if 926417919 
import java.awt.Color;
//#endif 


//#if -510866724 
import java.awt.Dimension;
//#endif 


//#if 598218473 
import java.awt.Graphics;
//#endif 


//#if -1059019050 
import java.awt.event.MouseAdapter;
//#endif 


//#if -710067349 
import java.awt.event.MouseEvent;
//#endif 


//#if 472702020 
import javax.swing.JPanel;
//#endif 


//#if -2013144963 
import javax.swing.JPopupMenu;
//#endif 


//#if -1790909299 
class PlaygroundMouseAdapter  { 

//#if -1628183720 
public boolean hook(MouseEvent e, int x, int y)
    { 

//#if -1540241253 
if(e.isPopupTrigger() || e.getButton()==MouseEvent.BUTTON3)//1
{ 

//#if -1795495062 
JPopupMenu popup = new PopUpMenu(playgroundPanel.getModel(), x, y);
//#endif 


//#if 586411000 
popup.show(playgroundPanel,
                       e.getX(), e.getY());
//#endif 


//#if 639175672 
return true;
//#endif 

} 
else
{ 

//#if 1630055499 
return false;
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

