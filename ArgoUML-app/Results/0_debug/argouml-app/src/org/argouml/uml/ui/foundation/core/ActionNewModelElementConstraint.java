
//#if -1021244507 
// Compilation Unit of /ActionNewModelElementConstraint.java 
 

//#if -393103309 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 2126017581 
import java.awt.event.ActionEvent;
//#endif 


//#if -112199506 
import org.argouml.model.Model;
//#endif 


//#if 1376517737 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if -1761102688 
public class ActionNewModelElementConstraint extends 
//#if -5720758 
AbstractActionNewModelElement
//#endif 

  { 

//#if 979360874 
private static final ActionNewModelElementConstraint SINGLETON =
        new ActionNewModelElementConstraint();
//#endif 


//#if 1755243166 
protected ActionNewModelElementConstraint()
    { 

//#if 889436283 
super();
//#endif 

} 

//#endif 


//#if -40787492 
public void actionPerformed(ActionEvent e)
    { 

//#if -1683113124 
super.actionPerformed(e);
//#endif 


//#if -165857196 
Model.getCoreFactory().buildConstraint(getTarget());
//#endif 

} 

//#endif 


//#if 254269114 
public static ActionNewModelElementConstraint getInstance()
    { 

//#if 35410556 
return SINGLETON;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

