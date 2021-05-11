
//#if -1446753567 
// Compilation Unit of /UMLInstanceLinkEndListModel.java 
 

//#if -12380991 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -497629908 
import org.argouml.model.Model;
//#endif 


//#if 1345350264 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 848919415 
public class UMLInstanceLinkEndListModel extends 
//#if 314303547 
UMLModelElementListModel2
//#endif 

  { 

//#if 81116024 
public UMLInstanceLinkEndListModel()
    { 

//#if -665392495 
super("linkEnd");
//#endif 

} 

//#endif 


//#if 740278109 
protected boolean isValidElement(Object element)
    { 

//#if 1342536127 
return Model.getFacade().getLinkEnds(getTarget()).contains(element);
//#endif 

} 

//#endif 


//#if -1825289943 
protected void buildModelList()
    { 

//#if 1229383414 
if(getTarget() != null)//1
{ 

//#if 94253897 
setAllElements(Model.getFacade().getLinkEnds(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

