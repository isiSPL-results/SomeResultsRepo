// Compilation Unit of /LanguageComboBox.java 
 
package org.argouml.language.ui;
import java.awt.Dimension;
import java.util.Iterator;
import javax.swing.JComboBox;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoGeneratorEvent;
import org.argouml.application.events.ArgoGeneratorEventListener;
import org.argouml.uml.generator.GeneratorManager;
import org.argouml.uml.generator.Language;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

public class LanguageComboBox extends JComboBox
 implements ArgoGeneratorEventListener
  { 

//#if LOGGING 
private static final Logger LOG = Logger.getLogger(LanguageComboBox.class);
//#endif 

public void refresh()
    { 
removeAllItems();
Iterator iterator =
            GeneratorManager.getInstance().getLanguages().iterator();
while (iterator.hasNext()) //1
{ 
try //1
{ 
Language ll = (Language) iterator.next();
addItem(ll);
} 
catch (Exception e) //1
{ 

//#if LOGGING 
LOG.error("Unexpected exception", e);
//#endif 

} 


} 

setVisible(true);
invalidate();
} 

public LanguageComboBox()
    { 
super();
setEditable(false);
setMaximumRowCount(6);
Dimension d = getPreferredSize();
d.width = 200;
setMaximumSize(d);
ArgoEventPump.addListener(ArgoEventTypes.ANY_GENERATOR_EVENT, this);
refresh();
} 

public void generatorRemoved(ArgoGeneratorEvent e)
    { 
refresh();
} 

public void generatorChanged(ArgoGeneratorEvent e)
    { 
refresh();
} 

public void generatorAdded(ArgoGeneratorEvent e)
    { 
refresh();
} 

protected void finalize()
    { 
ArgoEventPump.removeListener(this);
} 

 } 


