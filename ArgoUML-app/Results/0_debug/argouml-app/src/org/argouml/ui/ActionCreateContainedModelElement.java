
//#if 160376556 
// Compilation Unit of /ActionCreateContainedModelElement.java 
 

//#if -1855513805 
package org.argouml.ui;
//#endif 


//#if 365959827 
import java.awt.event.ActionEvent;
//#endif 


//#if -2044568568 
import org.argouml.model.Model;
//#endif 


//#if -1950261158 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 654718031 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if -304747788 
public class ActionCreateContainedModelElement extends 
//#if 1205878164 
AbstractActionNewModelElement
//#endif 

  { 

//#if 1975795329 
private Object metaType;
//#endif 


//#if -1583584811 
public ActionCreateContainedModelElement(
        Object theMetaType,
        Object target,
        String menuDescr)
    { 

//#if 1423220092 
super(menuDescr);
//#endif 


//#if -1484539234 
metaType = theMetaType;
//#endif 


//#if 1410575619 
setTarget(target);
//#endif 

} 

//#endif 


//#if 907728294 
public void actionPerformed(ActionEvent e)
    { 

//#if 1151999558 
Object newElement = Model.getUmlFactory().buildNode(metaType,
                            getTarget());
//#endif 


//#if -338271202 
TargetManager.getInstance().setTarget(newElement);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

