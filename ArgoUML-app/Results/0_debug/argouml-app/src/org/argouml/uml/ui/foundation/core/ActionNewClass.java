
//#if 1794891555 
// Compilation Unit of /ActionNewClass.java 
 

//#if 103137444 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 911276188 
import java.awt.event.ActionEvent;
//#endif 


//#if 1297244690 
import javax.swing.Action;
//#endif 


//#if 1378747225 
import org.argouml.i18n.Translator;
//#endif 


//#if 669016735 
import org.argouml.model.Model;
//#endif 


//#if -792785821 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -2044004968 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if -146964457 
public class ActionNewClass extends 
//#if -1295330602 
AbstractActionNewModelElement
//#endif 

  { 

//#if 81883325 
public ActionNewClass()
    { 

//#if 160119411 
super("button.new-class");
//#endif 


//#if -635032493 
putValue(Action.NAME, Translator.localize("button.new-class"));
//#endif 

} 

//#endif 


//#if 59064424 
public void actionPerformed(ActionEvent e)
    { 

//#if 879900556 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 2000314618 
if(Model.getFacade().isAClassifier(target))//1
{ 

//#if -748181974 
Object classifier = target;
//#endif 


//#if -1082856072 
Object ns = Model.getFacade().getNamespace(classifier);
//#endif 


//#if 1005784926 
if(ns != null)//1
{ 

//#if -1192215928 
Object peer = Model.getCoreFactory().buildClass(ns);
//#endif 


//#if 549178931 
TargetManager.getInstance().setTarget(peer);
//#endif 


//#if 1945811984 
super.actionPerformed(e);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

