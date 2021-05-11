
//#if 239230340 
// Compilation Unit of /ActionSetRepresentedClassifierCollaboration.java 
 

//#if 31667590 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if 85073546 
import java.awt.event.ActionEvent;
//#endif 


//#if -756271574 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1536269099 
import org.argouml.i18n.Translator;
//#endif 


//#if 1549579121 
import org.argouml.model.Model;
//#endif 


//#if 228350196 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -1570489568 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1619415991 
class ActionSetRepresentedClassifierCollaboration extends 
//#if -1345208089 
UndoableAction
//#endif 

  { 

//#if -944644326 
public void actionPerformed(ActionEvent e)
    { 

//#if -1966615736 
super.actionPerformed(e);
//#endif 


//#if 1978348081 
if(e.getSource() instanceof UMLComboBox2)//1
{ 

//#if 1533615226 
UMLComboBox2 source = (UMLComboBox2) e.getSource();
//#endif 


//#if -679978894 
Object target = source.getTarget();
//#endif 


//#if -35640843 
Object newValue = source.getSelectedItem();
//#endif 


//#if -965975201 
if(!Model.getFacade().isAClassifier(newValue))//1
{ 

//#if 1757694390 
newValue = null;
//#endif 

} 

//#endif 


//#if -935202325 
if(Model.getFacade().getRepresentedClassifier(target)
                    != newValue)//1
{ 

//#if -438141714 
Model.getCollaborationsHelper().setRepresentedClassifier(
                    target, newValue);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -2146439465 
ActionSetRepresentedClassifierCollaboration()
    { 

//#if 1280102063 
super(Translator.localize("action.set"),
              ResourceLoaderWrapper.lookupIcon("action.set"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

