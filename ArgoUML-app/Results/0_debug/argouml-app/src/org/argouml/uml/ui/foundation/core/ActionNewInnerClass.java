
//#if -1062158740 
// Compilation Unit of /ActionNewInnerClass.java 
 

//#if -864499515 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -951380133 
import java.awt.event.ActionEvent;
//#endif 


//#if -1311068207 
import javax.swing.Action;
//#endif 


//#if -529023878 
import org.argouml.i18n.Translator;
//#endif 


//#if 57529408 
import org.argouml.model.Model;
//#endif 


//#if 1148833058 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -358880489 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if -1136208092 
public class ActionNewInnerClass extends 
//#if -73395204 
AbstractActionNewModelElement
//#endif 

  { 

//#if 829409806 
public void actionPerformed(ActionEvent e)
    { 

//#if 184706821 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -1027392013 
if(Model.getFacade().isAClassifier(target))//1
{ 

//#if -634594952 
Object classifier = /* (MClassifier) */target;
//#endif 


//#if -390768570 
Object inner = Model.getCoreFactory().buildClass(classifier);
//#endif 


//#if -832635651 
TargetManager.getInstance().setTarget(inner);
//#endif 


//#if -1315411644 
super.actionPerformed(e);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 748710437 
public ActionNewInnerClass()
    { 

//#if 131949448 
super("button.new-inner-class");
//#endif 


//#if 1893458394 
putValue(Action.NAME, Translator.localize("button.new-inner-class"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

