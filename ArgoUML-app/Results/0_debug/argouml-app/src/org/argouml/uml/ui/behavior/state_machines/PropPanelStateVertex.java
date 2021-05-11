
//#if -1025119569 
// Compilation Unit of /PropPanelStateVertex.java 
 

//#if -632853040 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -1846115166 
import javax.swing.ImageIcon;
//#endif 


//#if 1497806062 
import javax.swing.JList;
//#endif 


//#if -705685690 
import javax.swing.JPanel;
//#endif 


//#if 1984596951 
import javax.swing.JScrollPane;
//#endif 


//#if 54569961 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if 1185507008 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if -758088693 
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
//#endif 


//#if -2099470712 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if -738147053 
public abstract class PropPanelStateVertex extends 
//#if -918336533 
PropPanelModelElement
//#endif 

  { 

//#if -1136503517 
private JScrollPane incomingScroll;
//#endif 


//#if -949551331 
private JScrollPane outgoingScroll;
//#endif 


//#if 1519522529 
private JPanel containerScroll;
//#endif 


//#if 1937184184 
protected JPanel getContainerScroll()
    { 

//#if 854421291 
return containerScroll;
//#endif 

} 

//#endif 


//#if -1123867376 
protected JScrollPane getIncomingScroll()
    { 

//#if -417223440 
return incomingScroll;
//#endif 

} 

//#endif 


//#if 376683094 
protected JScrollPane getOutgoingScroll()
    { 

//#if -1802055041 
return outgoingScroll;
//#endif 

} 

//#endif 


//#if 65806202 
protected void addExtraButtons() { 
} 

//#endif 


//#if -466829014 
public PropPanelStateVertex(String name, ImageIcon icon)
    { 

//#if 1009194054 
super(name, icon);
//#endif 


//#if -897473590 
JList incomingList = new UMLLinkedList(
            new UMLStateVertexIncomingListModel());
//#endif 


//#if -70737074 
incomingScroll = new JScrollPane(incomingList);
//#endif 


//#if -647624566 
JList outgoingList = new UMLLinkedList(
            new UMLStateVertexOutgoingListModel());
//#endif 


//#if 772891226 
outgoingScroll = new JScrollPane(outgoingList);
//#endif 


//#if -50673913 
containerScroll =
            getSingleRowScroll(new UMLStateVertexContainerListModel());
//#endif 


//#if 1003787819 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if 1399179681 
addExtraButtons();
//#endif 


//#if -2021058055 
addAction(new ActionNewStereotype());
//#endif 


//#if -1399589248 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

