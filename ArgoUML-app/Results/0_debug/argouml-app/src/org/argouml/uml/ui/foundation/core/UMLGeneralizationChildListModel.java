
//#if 1848395142 
// Compilation Unit of /UMLGeneralizationChildListModel.java 
 

//#if 2000442697 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1239221956 
import org.argouml.model.Model;
//#endif 


//#if -869034016 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 1874778043 
public class UMLGeneralizationChildListModel extends 
//#if -1327117325 
UMLModelElementListModel2
//#endif 

  { 

//#if -1985096190 
protected boolean isValidElement(Object o)
    { 

//#if -877748540 
return (Model.getFacade().getSpecific(getTarget()) == o);
//#endif 

} 

//#endif 


//#if -1486936868 
public UMLGeneralizationChildListModel()
    { 

//#if 142376643 
super("child");
//#endif 

} 

//#endif 


//#if -1238133535 
protected void buildModelList()
    { 

//#if -1664810781 
if(getTarget() == null)//1
{ 

//#if 1745542007 
return;
//#endif 

} 

//#endif 


//#if -122487427 
removeAllElements();
//#endif 


//#if 221173547 
addElement(Model.getFacade().getSpecific(getTarget()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

