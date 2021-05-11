
//#if -2017541754 
// Compilation Unit of /UMLLinkMouseListener.java 
 

//#if -1101460129 
package org.argouml.uml.ui;
//#endif 


//#if 1536190032 
import java.awt.event.MouseEvent;
//#endif 


//#if 511418936 
import java.awt.event.MouseListener;
//#endif 


//#if 200882197 
import javax.swing.JList;
//#endif 


//#if 2122534733 
import javax.swing.SwingUtilities;
//#endif 


//#if 1884224846 
import org.argouml.model.Model;
//#endif 


//#if 1478999380 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1203148635 
public class UMLLinkMouseListener implements 
//#if 648392069 
MouseListener
//#endif 

  { 

//#if -806327663 
private JList owner = null;
//#endif 


//#if -1203308981 
private int numberOfMouseClicks;
//#endif 


//#if 203276095 
public UMLLinkMouseListener(JList theOwner)
    { 

//#if -1532493229 
this(theOwner, 2);
//#endif 

} 

//#endif 


//#if -1024306384 
public void mouseExited(MouseEvent e)
    { 
} 

//#endif 


//#if 172104670 
public void mouseEntered(MouseEvent e)
    { 
} 

//#endif 


//#if -626146408 
private UMLLinkMouseListener(JList theOwner, int numberOfmouseClicks)
    { 

//#if 1216110156 
owner = theOwner;
//#endif 


//#if 2031839131 
numberOfMouseClicks = numberOfmouseClicks;
//#endif 

} 

//#endif 


//#if -1790081744 
public void mouseReleased(MouseEvent e)
    { 
} 

//#endif 


//#if -80766189 
public void mousePressed(MouseEvent e)
    { 
} 

//#endif 


//#if 1628710702 
public void mouseClicked(MouseEvent e)
    { 

//#if -694879955 
if(e.getClickCount() >= numberOfMouseClicks
                && SwingUtilities.isLeftMouseButton(e))//1
{ 

//#if 1452737655 
Object o = owner.getSelectedValue();
//#endif 


//#if -415017646 
if(Model.getFacade().isAModelElement(o))//1
{ 

//#if 563941683 
TargetManager.getInstance().setTarget(o);
//#endif 

} 

//#endif 


//#if 2111417474 
e.consume();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

