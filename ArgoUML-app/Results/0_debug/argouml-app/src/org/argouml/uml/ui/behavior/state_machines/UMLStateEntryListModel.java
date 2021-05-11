
//#if -887217929 
// Compilation Unit of /UMLStateEntryListModel.java 
 

//#if 1685569172 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -1627582933 
import org.argouml.model.Model;
//#endif 


//#if -1292106023 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 1315369555 
public class UMLStateEntryListModel extends 
//#if -629030167 
UMLModelElementListModel2
//#endif 

  { 

//#if 85531013 
public UMLStateEntryListModel()
    { 

//#if -1509001581 
super("entry");
//#endif 

} 

//#endif 


//#if -1807647989 
protected boolean isValidElement(Object element)
    { 

//#if -1208166604 
return element == Model.getFacade().getEntry(getTarget());
//#endif 

} 

//#endif 


//#if 846143703 
protected void buildModelList()
    { 

//#if -417960615 
removeAllElements();
//#endif 


//#if -368533821 
addElement(Model.getFacade().getEntry(getTarget()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

