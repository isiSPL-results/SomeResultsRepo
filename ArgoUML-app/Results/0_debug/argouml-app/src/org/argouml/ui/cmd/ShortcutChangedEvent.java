
//#if 1510293996 
// Compilation Unit of /ShortcutChangedEvent.java 
 

//#if -1230720955 
package org.argouml.ui.cmd;
//#endif 


//#if 1782772436 
import java.util.EventObject;
//#endif 


//#if -92558530 
import javax.swing.KeyStroke;
//#endif 


//#if 663984526 
public class ShortcutChangedEvent extends 
//#if 1331896994 
EventObject
//#endif 

  { 

//#if -353289696 
private static final long serialVersionUID = 961611716902568240L;
//#endif 


//#if 255863919 
private KeyStroke keyStroke;
//#endif 


//#if -465167335 
public KeyStroke getKeyStroke()
    { 

//#if -627417120 
return keyStroke;
//#endif 

} 

//#endif 


//#if 1509776562 
public ShortcutChangedEvent(Object source, KeyStroke newStroke)
    { 

//#if -1339108079 
super(source);
//#endif 


//#if 728982242 
this.keyStroke = newStroke;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

