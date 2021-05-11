
//#if -1629064230 
// Compilation Unit of /UMLAssociationLinkListModel.java 
 

//#if 630796504 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1099726637 
import org.argouml.model.Model;
//#endif 


//#if -836547279 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1041724145 
public class UMLAssociationLinkListModel extends 
//#if 1892770188 
UMLModelElementListModel2
//#endif 

  { 

//#if -1287586758 
public UMLAssociationLinkListModel()
    { 

//#if 965390040 
super("link");
//#endif 

} 

//#endif 


//#if -994527750 
protected void buildModelList()
    { 

//#if -1688010811 
if(getTarget() != null)//1
{ 

//#if 2121583105 
setAllElements(Model.getFacade().getLinks(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -78435365 
protected boolean isValidElement(Object o)
    { 

//#if -1700050086 
return Model.getFacade().isALink(o)
               && Model.getFacade().getLinks(getTarget()).contains(o);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

