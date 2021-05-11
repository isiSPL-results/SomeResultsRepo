
//#if -1691266386 
// Compilation Unit of /UMLInstanceReceiverStimulusListModel.java 
 

//#if 401287339 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -781004030 
import org.argouml.model.Model;
//#endif 


//#if 1759018594 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 138349471 
public class UMLInstanceReceiverStimulusListModel extends 
//#if -1105709886 
UMLModelElementListModel2
//#endif 

  { 

//#if 1042249167 
public UMLInstanceReceiverStimulusListModel()
    { 

//#if 1102685197 
super("stimulus");
//#endif 

} 

//#endif 


//#if -1621688784 
protected void buildModelList()
    { 

//#if -906132636 
removeAllElements();
//#endif 


//#if 396880276 
addElement(Model.getFacade().getReceivedStimuli(getTarget()));
//#endif 

} 

//#endif 


//#if 48072292 
protected boolean isValidElement(Object element)
    { 

//#if -725210059 
return Model.getFacade().getReceivedStimuli(getTarget()).contains(
                   element);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

