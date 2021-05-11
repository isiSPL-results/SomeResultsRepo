
//#if -368761259 
// Compilation Unit of /LanguageComboBox.java 
 

//#if 1185663752 
package org.argouml.language.ui;
//#endif 


//#if 45079264 
import java.awt.Dimension;
//#endif 


//#if -312404804 
import java.util.Iterator;
//#endif 


//#if -457539763 
import javax.swing.JComboBox;
//#endif 


//#if 2048728923 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if -795621542 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 1862302674 
import org.argouml.application.events.ArgoGeneratorEvent;
//#endif 


//#if -209656194 
import org.argouml.application.events.ArgoGeneratorEventListener;
//#endif 


//#if 1747054558 
import org.argouml.uml.generator.GeneratorManager;
//#endif 


//#if 1507488416 
import org.argouml.uml.generator.Language;
//#endif 


//#if -1790999502 
import org.apache.log4j.Logger;
//#endif 


//#if -1213242536 
public class LanguageComboBox extends 
//#if 1637297135 
JComboBox
//#endif 

 implements 
//#if -366818676 
ArgoGeneratorEventListener
//#endif 

  { 

//#if -424210293 
private static final Logger LOG = Logger.getLogger(LanguageComboBox.class);
//#endif 


//#if -791568281 
public void refresh()
    { 

//#if -137080747 
removeAllItems();
//#endif 


//#if -859818693 
Iterator iterator =
            GeneratorManager.getInstance().getLanguages().iterator();
//#endif 


//#if -2100220561 
while (iterator.hasNext()) //1
{ 

//#if -1183341909 
try //1
{ 

//#if -701965804 
Language ll = (Language) iterator.next();
//#endif 


//#if 1394250151 
addItem(ll);
//#endif 

} 

//#if 66880133 
catch (Exception e) //1
{ 

//#if -426648863 
LOG.error("Unexpected exception", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 2028659926 
setVisible(true);
//#endif 


//#if 720498269 
invalidate();
//#endif 

} 

//#endif 


//#if -1395669577 
public LanguageComboBox()
    { 

//#if -735603154 
super();
//#endif 


//#if 432678852 
setEditable(false);
//#endif 


//#if -2087263230 
setMaximumRowCount(6);
//#endif 


//#if -216475682 
Dimension d = getPreferredSize();
//#endif 


//#if 1592816889 
d.width = 200;
//#endif 


//#if 1737865692 
setMaximumSize(d);
//#endif 


//#if 1428291056 
ArgoEventPump.addListener(ArgoEventTypes.ANY_GENERATOR_EVENT, this);
//#endif 


//#if -1090656498 
refresh();
//#endif 

} 

//#endif 


//#if -2051900854 
public void generatorRemoved(ArgoGeneratorEvent e)
    { 

//#if -1495371275 
refresh();
//#endif 

} 

//#endif 


//#if -1225872266 
public void generatorChanged(ArgoGeneratorEvent e)
    { 

//#if -1048819861 
refresh();
//#endif 

} 

//#endif 


//#if 33525034 
public void generatorAdded(ArgoGeneratorEvent e)
    { 

//#if 1266782172 
refresh();
//#endif 

} 

//#endif 


//#if -1615222903 
protected void finalize()
    { 

//#if -1520521428 
ArgoEventPump.removeListener(this);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

