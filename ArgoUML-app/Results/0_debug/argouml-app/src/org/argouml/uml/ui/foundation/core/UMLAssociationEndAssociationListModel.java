
//#if 1187955061 
// Compilation Unit of /UMLAssociationEndAssociationListModel.java 
 

//#if -262580433 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -667864662 
import org.argouml.model.Model;
//#endif 


//#if 119756986 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 1445346682 
public class UMLAssociationEndAssociationListModel extends 
//#if -1424492913 
UMLModelElementListModel2
//#endif 

  { 

//#if 2139060113 
public UMLAssociationEndAssociationListModel()
    { 

//#if 424113942 
super("association");
//#endif 

} 

//#endif 


//#if -504406095 
protected boolean isValidElement(Object element)
    { 

//#if -666930668 
return Model.getFacade().isAAssociation(element)
               && Model.getFacade().getAssociation(getTarget()).equals(element);
//#endif 

} 

//#endif 


//#if -1613295235 
protected void buildModelList()
    { 

//#if -1336403494 
removeAllElements();
//#endif 


//#if -778942628 
if(getTarget() != null)//1
{ 

//#if -771445169 
addElement(Model.getFacade().getAssociation(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

