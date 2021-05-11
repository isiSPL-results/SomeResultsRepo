
//#if -2098956885 
// Compilation Unit of /UMLExtensionPointExtendListModel.java 
 

//#if 367282538 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if 592539518 
import org.argouml.model.Model;
//#endif 


//#if 876201830 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 1960151862 
public class UMLExtensionPointExtendListModel extends 
//#if -1497328219 
UMLModelElementListModel2
//#endif 

  { 

//#if -336708641 
public UMLExtensionPointExtendListModel()
    { 

//#if 1076300334 
super("extend");
//#endif 

} 

//#endif 


//#if 1229862291 
protected void buildModelList()
    { 

//#if 2102396731 
setAllElements(Model.getFacade().getExtends(getTarget()));
//#endif 

} 

//#endif 


//#if -83574732 
protected boolean isValidElement(Object o)
    { 

//#if 994158244 
return Model.getFacade().isAExtend(o)
               && Model.getFacade().getExtends(getTarget()).contains(o);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

