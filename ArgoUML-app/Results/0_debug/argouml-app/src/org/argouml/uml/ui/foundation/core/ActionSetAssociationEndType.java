
//#if -455970550 
// Compilation Unit of /ActionSetAssociationEndType.java 
 

//#if -669213341 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1892546813 
import java.awt.event.ActionEvent;
//#endif 


//#if 1818383219 
import javax.swing.Action;
//#endif 


//#if 1733365528 
import org.argouml.i18n.Translator;
//#endif 


//#if -5954082 
import org.argouml.model.Model;
//#endif 


//#if -2089415071 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if 73659027 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1155947830 
public class ActionSetAssociationEndType extends 
//#if 1818946509 
UndoableAction
//#endif 

  { 

//#if 1165350918 
private static final ActionSetAssociationEndType SINGLETON =
        new ActionSetAssociationEndType();
//#endif 


//#if -1458201092 
public static ActionSetAssociationEndType getInstance()
    { 

//#if 2016685771 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 872009452 
protected ActionSetAssociationEndType()
    { 

//#if 637574745 
super(Translator.localize("Set"), null);
//#endif 


//#if 712083542 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 


//#if 782373914 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if 1842216176 
super.actionPerformed(e);
//#endif 


//#if 804549791 
Object source = e.getSource();
//#endif 


//#if -338144022 
Object oldClassifier = null;
//#endif 


//#if -1161019805 
Object newClassifier = null;
//#endif 


//#if -901562979 
Object end = null;
//#endif 


//#if -2027273115 
if(source instanceof UMLComboBox2)//1
{ 

//#if -1955640954 
UMLComboBox2 box = (UMLComboBox2) source;
//#endif 


//#if 2102769354 
Object o = box.getTarget();
//#endif 


//#if 456256863 
if(Model.getFacade().isAAssociationEnd(o))//1
{ 

//#if -974113389 
end = o;
//#endif 


//#if 2031671577 
oldClassifier = Model.getFacade().getType(end);
//#endif 

} 

//#endif 


//#if 1151977742 
o = box.getSelectedItem();
//#endif 


//#if 1601865080 
if(Model.getFacade().isAClassifier(o))//1
{ 

//#if -1097790689 
newClassifier = o;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 224371438 
if(newClassifier != oldClassifier && end != null
                && newClassifier != null)//1
{ 

//#if 1835355936 
Model.getCoreHelper().setType(end, newClassifier);
//#endif 


//#if 2137233375 
super.actionPerformed(e);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

