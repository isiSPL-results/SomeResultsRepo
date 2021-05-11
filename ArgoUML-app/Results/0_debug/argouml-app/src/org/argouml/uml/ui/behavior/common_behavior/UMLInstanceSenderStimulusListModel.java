
//#if -1603438233 
// Compilation Unit of /UMLInstanceSenderStimulusListModel.java 
 

//#if -809229626 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 1435196935 
import org.argouml.model.Model;
//#endif 


//#if 548501629 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 691791284 
public class UMLInstanceSenderStimulusListModel extends 
//#if -1825438527 
UMLModelElementListModel2
//#endif 

  { 

//#if -1300128598 
public UMLInstanceSenderStimulusListModel()
    { 

//#if -1866509494 
super("stimulus");
//#endif 

} 

//#endif 


//#if -1292192081 
protected void buildModelList()
    { 

//#if 1578526289 
removeAllElements();
//#endif 


//#if 132779960 
addElement(Model.getFacade().getSentStimuli(getTarget()));
//#endif 

} 

//#endif 


//#if -1940496157 
protected boolean isValidElement(Object element)
    { 

//#if -1752253896 
return Model.getFacade().getSentStimuli(getTarget()).contains(element);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

