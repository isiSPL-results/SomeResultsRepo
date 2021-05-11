
//#if -1318587844 
// Compilation Unit of /UMLGeneralizationParentListModel.java 
 

//#if -1714722408 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -2019239533 
import org.argouml.model.Model;
//#endif 


//#if 973401201 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 1961632358 
public class UMLGeneralizationParentListModel extends 
//#if -584775382 
UMLModelElementListModel2
//#endif 

  { 

//#if 160652952 
protected void buildModelList()
    { 

//#if -1733978286 
if(getTarget() == null)//1
{ 

//#if 739795155 
return;
//#endif 

} 

//#endif 


//#if 2139497324 
removeAllElements();
//#endif 


//#if 1912667744 
addElement(Model.getFacade().getGeneral(getTarget()));
//#endif 

} 

//#endif 


//#if 1914840825 
protected boolean isValidElement(Object o)
    { 

//#if 944805024 
return (Model.getFacade().getGeneral(getTarget()) == o);
//#endif 

} 

//#endif 


//#if -1154961505 
public UMLGeneralizationParentListModel()
    { 

//#if -1672073794 
super("parent");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

