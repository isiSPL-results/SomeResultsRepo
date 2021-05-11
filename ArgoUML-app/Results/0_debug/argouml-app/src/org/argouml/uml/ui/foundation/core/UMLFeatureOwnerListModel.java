
//#if 492949027 
// Compilation Unit of /UMLFeatureOwnerListModel.java 
 

//#if -1397109854 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1876851357 
import org.argouml.model.Model;
//#endif 


//#if 990066087 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -393334939 
public class UMLFeatureOwnerListModel extends 
//#if -1527909565 
UMLModelElementListModel2
//#endif 

  { 

//#if -550835985 
public UMLFeatureOwnerListModel()
    { 

//#if -149142765 
super("owner");
//#endif 

} 

//#endif 


//#if 1366749522 
protected boolean isValidElement(Object o)
    { 

//#if -1285382918 
return Model.getFacade().getOwner(getTarget()) == o;
//#endif 

} 

//#endif 


//#if -1875405775 
protected void buildModelList()
    { 

//#if 585681333 
if(getTarget() != null)//1
{ 

//#if -204300525 
removeAllElements();
//#endif 


//#if 684102684 
addElement(Model.getFacade().getOwner(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

