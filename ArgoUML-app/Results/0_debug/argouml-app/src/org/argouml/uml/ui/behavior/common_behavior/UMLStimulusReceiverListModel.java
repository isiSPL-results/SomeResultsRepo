
//#if 1237842444 
// Compilation Unit of /UMLStimulusReceiverListModel.java 
 

//#if -1654138479 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 1305910876 
import org.argouml.model.Model;
//#endif 


//#if -296407224 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 716293530 
public class UMLStimulusReceiverListModel extends 
//#if 554794444 
UMLModelElementListModel2
//#endif 

  { 

//#if 1263658606 
protected boolean isValidElement(Object element)
    { 

//#if -1520739585 
return Model.getFacade().getReceiver(getTarget()) == element;
//#endif 

} 

//#endif 


//#if -485445062 
protected void buildModelList()
    { 

//#if -1787890503 
removeAllElements();
//#endif 


//#if 1055687698 
addElement(Model.getFacade().getReceiver(getTarget()));
//#endif 

} 

//#endif 


//#if 1689456730 
public UMLStimulusReceiverListModel()
    { 

//#if 1929859924 
super("receiver");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

