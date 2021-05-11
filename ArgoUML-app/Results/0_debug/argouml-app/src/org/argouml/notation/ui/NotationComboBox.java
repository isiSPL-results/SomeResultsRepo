
//#if -238689100 
// Compilation Unit of /NotationComboBox.java 
 

//#if -443005862 
package org.argouml.notation.ui;
//#endif 


//#if 1659784840 
import java.awt.Dimension;
//#endif 


//#if 1996326374 
import java.util.ListIterator;
//#endif 


//#if -397440347 
import javax.swing.JComboBox;
//#endif 


//#if -258682621 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if 689064626 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 1364049709 
import org.argouml.application.events.ArgoNotationEvent;
//#endif 


//#if -701587751 
import org.argouml.application.events.ArgoNotationEventListener;
//#endif 


//#if 1175912755 
import org.argouml.notation.Notation;
//#endif 


//#if 1958128616 
import org.argouml.notation.NotationName;
//#endif 


//#if 129964426 
import org.apache.log4j.Logger;
//#endif 


//#if -611644502 
public class NotationComboBox extends 
//#if 2000591933 
JComboBox
//#endif 

 implements 
//#if 337710473 
ArgoNotationEventListener
//#endif 

  { 

//#if 1424947926 
private static NotationComboBox singleton;
//#endif 


//#if -522487653 
private static final long serialVersionUID = 4059899784583789412L;
//#endif 


//#if -663970685 
private static final Logger LOG = Logger.getLogger(NotationComboBox.class);
//#endif 


//#if -1382316235 
public void refresh()
    { 

//#if 1679195179 
removeAllItems();
//#endif 


//#if -624783094 
ListIterator iterator =
            Notation.getAvailableNotations().listIterator();
//#endif 


//#if 2123784153 
while (iterator.hasNext()) //1
{ 

//#if -1639659048 
try //1
{ 

//#if 709028998 
NotationName nn = (NotationName) iterator.next();
//#endif 


//#if 173847755 
addItem(nn);
//#endif 

} 

//#if 1373996989 
catch (Exception e) //1
{ 

//#if 839437399 
LOG.error("Unexpected exception", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -450031444 
setVisible(true);
//#endif 


//#if 1235186995 
invalidate();
//#endif 

} 

//#endif 


//#if 1511011052 
public void notationProviderAdded(ArgoNotationEvent event)
    { 
} 

//#endif 


//#if -1297821103 
public void notationChanged(ArgoNotationEvent event)
    { 
} 

//#endif 


//#if -806039348 
public void notationProviderRemoved(ArgoNotationEvent event)
    { 
} 

//#endif 


//#if 1817340883 
public NotationComboBox()
    { 

//#if -165078502 
super();
//#endif 


//#if 1552758872 
setEditable(false);
//#endif 


//#if -1384310034 
setMaximumRowCount(6);
//#endif 


//#if -176201014 
Dimension d = getPreferredSize();
//#endif 


//#if -613014811 
d.width = 200;
//#endif 


//#if 111429320 
setMaximumSize(d);
//#endif 


//#if -496558743 
ArgoEventPump.addListener(ArgoEventTypes.ANY_NOTATION_EVENT, this);
//#endif 


//#if 1722687482 
refresh();
//#endif 

} 

//#endif 


//#if -1423786403 
public void notationAdded(ArgoNotationEvent event)
    { 

//#if -617316738 
refresh();
//#endif 

} 

//#endif 


//#if 647119869 
public void notationRemoved(ArgoNotationEvent event)
    { 
} 

//#endif 


//#if -2056069940 
public static NotationComboBox getInstance()
    { 

//#if 1837925149 
if(singleton == null)//1
{ 

//#if -1430621497 
singleton = new NotationComboBox();
//#endif 

} 

//#endif 


//#if 1019206510 
return singleton;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

