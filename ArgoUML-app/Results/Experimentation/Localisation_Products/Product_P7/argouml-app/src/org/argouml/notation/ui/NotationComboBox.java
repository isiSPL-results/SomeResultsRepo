package org.argouml.notation.ui;
import java.awt.Dimension;
import java.util.ListIterator;
import javax.swing.JComboBox;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoNotationEvent;
import org.argouml.application.events.ArgoNotationEventListener;
import org.argouml.notation.Notation;
import org.argouml.notation.NotationName;
import org.apache.log4j.Logger;
public class NotationComboBox extends JComboBox
 implements ArgoNotationEventListener
  { 
private static NotationComboBox singleton;
private static final long serialVersionUID = 4059899784583789412L;
private static final Logger LOG = Logger.getLogger(NotationComboBox.class);
public void refresh()
    { 
removeAllItems();
ListIterator iterator =
            Notation.getAvailableNotations().listIterator();
while (iterator.hasNext()) //1
{ 
try//1
{ 
NotationName nn = (NotationName) iterator.next();
addItem(nn);
} 
catch (Exception e) //1
{ 
LOG.error("Unexpected exception", e);
} 
} 
setVisible(true);
invalidate();
} 
public void notationProviderAdded(ArgoNotationEvent event)
    { 
} 
public void notationChanged(ArgoNotationEvent event)
    { 
} 
public void notationProviderRemoved(ArgoNotationEvent event)
    { 
} 
public NotationComboBox()
    { 
super();
setEditable(false);
setMaximumRowCount(6);
Dimension d = getPreferredSize();
d.width = 200;
setMaximumSize(d);
ArgoEventPump.addListener(ArgoEventTypes.ANY_NOTATION_EVENT, this);
refresh();
} 
public void notationAdded(ArgoNotationEvent event)
    { 
refresh();
} 
public void notationRemoved(ArgoNotationEvent event)
    { 
} 
public static NotationComboBox getInstance()
    { 
if(singleton == null)//1
{ 
singleton = new NotationComboBox();
} 
return singleton;
} 

 } 
