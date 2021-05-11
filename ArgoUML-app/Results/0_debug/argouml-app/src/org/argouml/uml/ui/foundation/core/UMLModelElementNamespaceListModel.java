
//#if -842803128 
// Compilation Unit of /UMLModelElementNamespaceListModel.java 
 

//#if 688573283 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 300438494 
import org.argouml.model.Model;
//#endif 


//#if -339779834 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1480836787 
public class UMLModelElementNamespaceListModel extends 
//#if -896437109 
UMLModelElementListModel2
//#endif 

  { 

//#if -603401876 
public UMLModelElementNamespaceListModel()
    { 

//#if -1457517471 
super("namespace");
//#endif 

} 

//#endif 


//#if 1244213625 
protected void buildModelList()
    { 

//#if -1104610750 
removeAllElements();
//#endif 


//#if -777210940 
if(getTarget() != null)//1
{ 

//#if -1825586898 
addElement(Model.getFacade().getNamespace(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1587935315 
protected boolean isValidElement(Object element)
    { 

//#if 1995699268 
return Model.getFacade().getNamespace(getTarget()) == element;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

