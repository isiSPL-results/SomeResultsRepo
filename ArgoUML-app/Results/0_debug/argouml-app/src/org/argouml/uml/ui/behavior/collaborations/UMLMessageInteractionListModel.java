
//#if 572927745 
// Compilation Unit of /UMLMessageInteractionListModel.java 
 

//#if 2100787512 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if -2051128285 
import org.argouml.model.Model;
//#endif 


//#if 1074445281 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -108662159 
public class UMLMessageInteractionListModel extends 
//#if 1095010175 
UMLModelElementListModel2
//#endif 

  { 

//#if -2087053151 
protected boolean isValidElement(Object element)
    { 

//#if 27259153 
return Model.getFacade().isAInteraction(element)
               && Model.getFacade().getInteraction(getTarget()) == element;
//#endif 

} 

//#endif 


//#if -1875727547 
public UMLMessageInteractionListModel()
    { 

//#if 822970297 
super("interaction");
//#endif 

} 

//#endif 


//#if 980527725 
protected void buildModelList()
    { 

//#if -893861129 
if(Model.getFacade().isAMessage(getTarget()))//1
{ 

//#if -1434846434 
removeAllElements();
//#endif 


//#if 1221645224 
addElement(Model.getFacade().getInteraction(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

