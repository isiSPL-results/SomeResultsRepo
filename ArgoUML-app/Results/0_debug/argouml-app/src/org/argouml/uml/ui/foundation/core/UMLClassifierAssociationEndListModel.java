
//#if -449176924 
// Compilation Unit of /UMLClassifierAssociationEndListModel.java 
 

//#if 634727157 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1814560368 
import org.argouml.model.Model;
//#endif 


//#if 1158833076 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -913778828 
public class UMLClassifierAssociationEndListModel extends 
//#if -192372166 
UMLModelElementListModel2
//#endif 

  { 

//#if -1239319014 
public UMLClassifierAssociationEndListModel()
    { 

//#if -804296009 
super("association", Model.getMetaTypes().getAssociation());
//#endif 

} 

//#endif 


//#if 610529192 
protected void buildModelList()
    { 

//#if -901966155 
if(getTarget() != null)//1
{ 

//#if 1542004788 
setAllElements(Model.getFacade().getAssociationEnds(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1450670116 
protected boolean isValidElement(Object element)
    { 

//#if 1132022409 
return Model.getFacade().getAssociationEnds(getTarget())
               .contains(element);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

